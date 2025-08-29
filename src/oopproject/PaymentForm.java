package oopproject;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.time.LocalDateTime;// Import for drag-and-drop classes
import java.util.ArrayList;
import java.util.List;
public class PaymentForm extends javax.swing.JFrame {
private Order order;
private CustomerDashboard dashboard;
    private ViewCart viewCart;
    private Payment payment;
   private Customer customer;
    
 public PaymentForm(Order order, CustomerDashboard dashboard, ViewCart viewCart, Customer customer) {
    this.order = order;
        this.dashboard = dashboard;
        this.viewCart = viewCart;
        this.customer = customer; // May be null, but we'll fix in confirmPayment
        if (this.customer == null) {
            System.out.println("Warning: Customer is null in PaymentForm constructor, will attempt to fetch from dashboard.");
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        double amount = (order != null) ? order.calculateTotal() : 0.0;
        List<String> productNames = new ArrayList<>();
        if (order != null && order.getItems() != null) {
            for (Product product : order.getItems()) {
                productNames.add(product.getName());
            }
        }
        this.payment = new Payment("PAY" + System.currentTimeMillis(), "Cash on Delivery", amount, productNames);
        try {
            initComponents();
            setLocationRelativeTo(null);
            this.setSize(400, 600);
            loadPaymentData();
        } catch (Exception e) {
            System.err.println("Error initializing PaymentForm: " + e.getMessage());
            e.printStackTrace();
        }
}
    // Updated constructor to handle single-argument case for testing
    private PaymentForm(Order order) {
        this(order, null, null, null); // Delegate to main constructor with null values
    }

    private void loadPaymentData() {
        if (order != null && order.getItems() != null) {
            double subtotal = 0.0;
            StringBuilder receipt = new StringBuilder();
            receipt.append("********************************\n");
            receipt.append("         AutoExpert Receipt         \n");
            receipt.append("********************************\n");
            receipt.append("Store: AutoExpert Store\n");
            receipt.append("Order ID: ").append(order.getOrderId()).append("\n");
            receipt.append("Date: Monday, August 18, 2025 12:59 PM PKT\n");
            receipt.append("--------------------------------\n");
            receipt.append(String.format("%-25s %-5s %-10s\n", "Item", "Qty", "Price"));
            receipt.append("--------------------------------\n");
            for (Product product : order.getItems()) {
                double itemTotal = product.getPrice() * product.getSelectedQuantity();
                subtotal += itemTotal;
                receipt.append(String.format("%-25s %-5d $%-9.2f\n",
                        product.getName(), product.getSelectedQuantity(), itemTotal));
            }
            double serviceFee = 2.0;
            double deliveryFee = 5.0;
            double tax = subtotal * 0.05;
            double total = subtotal + tax + serviceFee + deliveryFee;
            receipt.append("--------------------------------\n");
            receipt.append(String.format("%-25s $%-9.2f\n", "Subtotal:", subtotal));
            receipt.append(String.format("%-25s $%-9.2f\n", "Service Fee:", serviceFee));
            receipt.append(String.format("%-25s $%-9.2f\n", "Delivery Fee:", deliveryFee));
            receipt.append(String.format("%-25s $%-9.2f\n", "Tax (5%):", tax));
            receipt.append("--------------------------------\n");
            receipt.append(String.format("%-25s $%-9.2f\n", "Total:", total));
            receipt.append("--------------------------------\n");
            receipt.append("Payment Method: ").append(payment.getMethod()).append("\n");
            receipt.append("Payment ID: ").append(payment.getPaymentID()).append("\n");
            receipt.append("--------------------------------\n");
            receipt.append("Thank you for your order!\n");
            receipt.append("Track your order: https://AutoExpert.com/track/")
                    .append(order.getOrderId()).append("\n");
            receipt.append("********************************\n");

            jLabel_total.setText("Total Amount: $" + String.format("%.2f", total));
            jTextArea_receipt.setText(receipt.toString());
        } else {
            jLabel_total.setText("Total Amount: $0.00");
            jTextArea_receipt.setText("No payment data available.");
        }
    }
  
    private void confirmPayment() {
        String selectedMethod = (String) jComboBox1.getSelectedItem();
        if (selectedMethod.equals("Credit Card")) {
            String cardNumber = JOptionPane.showInputDialog(this, "Enter 16-digit Credit Card Number:");
            if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
                JOptionPane.showMessageDialog(this, "Invalid or missing card number. Please enter a 16-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try {
            double subtotal = 0.0;
            for (Product product : order.getItems()) {
                double itemTotal = product.getPrice() * product.getSelectedQuantity();
                subtotal += itemTotal;
            }
            double serviceFee = 2.0;
            double deliveryFee = 5.0;
            double tax = subtotal * 0.05;
            double total = subtotal + tax + serviceFee + deliveryFee;

            boolean insufficientStock = false;
            for (Product orderItem : order.getItems()) {
                for (Product product : dashboard.allProducts) {
                    if (product.getName().equals(orderItem.getName()) && product.getBrand().equals(orderItem.getBrand())) {
                        int newStock = product.getStockQuantity() - orderItem.getSelectedQuantity();
                        if (newStock < 0) {
                            insufficientStock = true;
                            JOptionPane.showMessageDialog(this,
                                "Insufficient stock for " + product.getName() + "!\n" +
                                "Available stock: " + product.getStockQuantity() + "\n" +
                                "Please select less than or equal to " + product.getStockQuantity() + " items.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        product.setStockQuantity(newStock);
                        break;
                    }
                }
            }

            if (!insufficientStock) {
                Product.saveToFile(dashboard.allProducts, "C:\\Users\\Dell\\Desktop\\Sadia\\inventory.txt");

                // Fetch customer from dashboard if null
                Customer currentCustomer = (this.customer != null) ? this.customer : dashboard.loggedInCustomer;
                if (currentCustomer == null) {
                    throw new IllegalStateException("No customer available to process order!");
                }

                order.setPaymentMethod(selectedMethod);
                currentCustomer.addOrder(order, "orders.txt"); // Use fetched customer

                payment = new Payment("PAY" + System.currentTimeMillis(), selectedMethod, total, payment.getProductNames());
                payment.processPayment();
                payment.savePayment("payments.txt");
                order.confirmOrder();
                if (order.getInvoice() != null) {
                    order.getInvoice().setTotalAmount(total);
                }
                InvoiceForm invoiceForm = new InvoiceForm(order);
                invoiceForm.setVisible(true);
                invoiceForm.pack();
                invoiceForm.setLocationRelativeTo(null);
                this.dispose();
            }
        } catch (Exception e) {
            System.err.println("Error in payment confirmation: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error processing payment: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_paymentMethod = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel_total = new javax.swing.JLabel();
        jButton_cancel = new javax.swing.JButton();
        jButton_confirm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_receipt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel_title.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_title.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel_title.setText("Payment Form");
        jLabel_title.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_paymentMethod.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel_paymentMethod.setText("Payment Method");

        jComboBox1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash on Delivery", "Credit Card" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel_total.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_total.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel_total.setText("Total Amount: ");

        jButton_cancel.setBackground(new java.awt.Color(30, 136, 229));
        jButton_cancel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton_cancel.setText("Cancel");
        jButton_cancel.setOpaque(true);
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });

        jButton_confirm.setBackground(new java.awt.Color(30, 136, 229));
        jButton_confirm.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton_confirm.setText("Confirm");
        jButton_confirm.setOpaque(true);
        jButton_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_confirmActionPerformed(evt);
            }
        });

        jTextArea_receipt.setColumns(20);
        jTextArea_receipt.setRows(5);
        jTextArea_receipt.setBorder(null);
        jTextArea_receipt.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea_receipt);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButton_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedMethod = (String) jComboBox1.getSelectedItem();
    payment = new Payment("PAY" + System.currentTimeMillis(), selectedMethod, payment.getAmount(), payment.getProductNames());
    order.setPaymentMethod(selectedMethod);
    loadPaymentData();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
       
        this.dispose();
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jButton_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_confirmActionPerformed
  confirmPayment();
    }//GEN-LAST:event_jButton_confirmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // [CHANGE] Added sample Order for testing
        java.awt.EventQueue.invokeLater(() -> {
           List<Product> sampleItems = new ArrayList<>();
            Product product1 = new Product("AC Compressor", "BrandX", 120.0, 2);
            Product product2 = new Product("AC Filter", "BrandY", 30.0, 1);
            sampleItems.add(product1);
            sampleItems.add(product2);
            Order order = new Order("ORD789", sampleItems);
            order.setPaymentMethod("Cash on Delivery");
            order.confirmOrder();
            Customer sampleCustomer = new Customer("test", "user", "test@example.com", "password", "12345"); // Proper customer
            CustomerDashboard dashboard = new CustomerDashboard(sampleCustomer); // Create dashboard
            new PaymentForm(order, dashboard, null, sampleCustomer).setVisible(true); // Pass dashboard and customer
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_confirm;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel_paymentMethod;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JLabel jLabel_total;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_receipt;
    // End of variables declaration//GEN-END:variables
}

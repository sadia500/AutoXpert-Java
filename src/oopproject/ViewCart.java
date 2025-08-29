package oopproject;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import oopproject.Customer;
import oopproject.CustomerDashboard;
import oopproject.InvoiceForm;
import oopproject.Order;
import oopproject.PaymentForm;
import oopproject.Product;

public class ViewCart extends javax.swing.JFrame {
    private Order order;
    private Customer customer;
    private JTable cartTable;
    private DefaultTableModel tableModel;
    private CustomerDashboard dashboard;
    private int selectedRow = -1;

    public ViewCart(CustomerDashboard dashboard, Order order) {
        this.dashboard = dashboard;
    this.order = order; // Can be null, we'll rely on dashboard.cartItems
    initComponents();
    cartTable = jTable1;
    setupTable();
    loadCartData();
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    ViewCart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_updateqauntity = new javax.swing.JButton();
        jButton_Remove = new javax.swing.JButton();
        jButton_checkout = new javax.swing.JButton();
        jButton_back = new javax.swing.JButton();
        jLabel_total = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_quantity = new javax.swing.JTextField();
        jButton_loadorder = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(650, 450));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 410));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(610, 350));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(570, 160));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Brand", "Qauntity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton_updateqauntity.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jButton_updateqauntity.setText("Update Qauntity");
        jButton_updateqauntity.setOpaque(true);
        jButton_updateqauntity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateqauntityActionPerformed(evt);
            }
        });

        jButton_Remove.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jButton_Remove.setText("Remove");
        jButton_Remove.setOpaque(true);
        jButton_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveActionPerformed(evt);
            }
        });

        jButton_checkout.setBackground(new java.awt.Color(30, 136, 229));
        jButton_checkout.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton_checkout.setForeground(new java.awt.Color(255, 255, 255));
        jButton_checkout.setText("Check Out");
        jButton_checkout.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder()));
        jButton_checkout.setOpaque(true);
        jButton_checkout.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton_checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_checkoutActionPerformed(evt);
            }
        });

        jButton_back.setBackground(new java.awt.Color(30, 136, 229));
        jButton_back.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton_back.setForeground(new java.awt.Color(255, 255, 255));
        jButton_back.setText("Back");
        jButton_back.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton_back.setOpaque(true);
        jButton_back.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        jLabel_total.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_total.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel_total.setText("Total");
        jLabel_total.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Qauntity");
        jLabel3.setOpaque(true);

        jTextField_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_quantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton_updateqauntity)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_total)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Remove)
                    .addComponent(jButton_updateqauntity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jButton_loadorder.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton_loadorder.setText("View Cart");
        jButton_loadorder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton_loadorder.setOpaque(true);
        jButton_loadorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loadorderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_loadorder, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_loadorder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   private void setupTable() {
    cartTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableModel = new DefaultTableModel(
        new Object[]{"Name", "Brand", "Quantity", "Price"},
        0
    );
    cartTable.setModel(tableModel);
    cartTable.getSelectionModel().addListSelectionListener(e -> {
            selectedRow = cartTable.getSelectedRow();
            System.out.println("Selected row: " + selectedRow);
        });
}

   private void loadCartData() {
    tableModel.setRowCount(0);
    System.out.println("Loading cart data. dashboard.cartItems: " + (dashboard != null ? dashboard.cartItems : "null"));
    if (dashboard != null && dashboard.cartItems != null) {
        for (Product item : dashboard.cartItems) {
            System.out.println("Adding to table: " + item.getName() + ", Brand: " + item.getBrand() + ", Selected Qty: " + item.getSelectedQuantity() + ", Price: " + item.getPrice());
            tableModel.addRow(new Object[]{item.getName(), item.getBrand(), item.getSelectedQuantity(), item.getPrice()});
        }
        updateTotal();
    } else {
        jLabel_total.setText("Total: $0.00");
    }
}

  private void updateTotal() {   
    double total = 0;
    if (dashboard != null && dashboard.cartItems != null) {
        for (Product item : dashboard.cartItems) {
            total += item.getPrice() * item.getSelectedQuantity();
        }
    }
    jLabel_total.setText("Total: $" + String.format("%.2f", total));
}

    private void jButton_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveActionPerformed
       if (selectedRow >= 0) {
            String itemName = (String) tableModel.getValueAt(selectedRow, 0);
            String itemBrand = (String) tableModel.getValueAt(selectedRow, 1);
            if (dashboard != null && dashboard.cartItems != null) {
                for (Product item : new ArrayList<>(dashboard.cartItems)) { // Use copy to avoid ConcurrentModificationException
                    if (item.getName().equals(itemName) && item.getBrand().equals(itemBrand)) {
                        int qtyToRestore = item.getSelectedQuantity();
                        for (Product p : dashboard.allProducts) {
                            if (p.getName().equals(itemName) && p.getBrand().equals(itemBrand)) {
                                p.setStockQuantity(p.getStockQuantity() + qtyToRestore);
                                break;
                            }
                        }
                        dashboard.totalCartItems -= qtyToRestore;
                        dashboard.cartItems.remove(item);
                        break;
                    }
                }
                loadCartData();
            } else {
                JOptionPane.showMessageDialog(this, "Item not found in order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_RemoveActionPerformed

    private void jButton_checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_checkoutActionPerformed
       System.out.println("Checkout button clicked. Dashboard: " + dashboard + ", CartItems: " + (dashboard != null ? dashboard.cartItems : "null"));

    if (dashboard == null || dashboard.cartItems == null || dashboard.cartItems.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Cart is empty or dashboard is invalid.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Create a new order with the current timestamp and cart items
        Order order = new Order("ORD_" + System.currentTimeMillis(), new ArrayList<>(dashboard.cartItems));
        System.out.println("Order created with ID: " + order.getOrderId() + ", Items: " + order.getItems());

        if (dashboard.loggedInCustomer != null) {
            System.out.println("Logged in customer: " + dashboard.loggedInCustomer.getName()); // Adjust based on your Customer class
            // Show order confirmation dialog
            String totalText = jLabel_total.getText();
            System.out.println("Total text from label: " + totalText);
            if (totalText == null || totalText.trim().isEmpty()) {
                throw new NumberFormatException("Total amount is null or empty");
            }
            double total = Double.parseDouble(totalText.replace("Total: $", "").trim());
            System.out.println("Parsed total: " + total);
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Confirm order for total: $" + String.format("%.2f", total), 
                "Confirm Order", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                // Proceed to PaymentForm
                System.out.println("Opening PaymentForm with order: " + order.getOrderId());
                PaymentForm paymentForm = new PaymentForm(order, dashboard, this, customer);
                paymentForm.setVisible(true);
                paymentForm.pack();
                paymentForm.setLocationRelativeTo(null);
                // PaymentForm will handle order saving and cart clearing on success
            } else {
                System.out.println("Order confirmation cancelled");
                JOptionPane.showMessageDialog(this, "Order cancelled.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            System.out.println("No logged in customer found");
            JOptionPane.showMessageDialog(this, "No customer logged in. Please log in to proceed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        System.err.println("Error parsing total amount: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error processing order: Invalid total amount. Please ensure the total is correctly displayed.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        System.err.println("Error during checkout: " + e.getMessage());
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error during checkout: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton_checkoutActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
      if (dashboard != null) {
        dashboard.setVisible(true); // Show the original dashboard
        this.dispose(); // Close the ViewCart window
    } else {
        JOptionPane.showMessageDialog(this, "Error: Dashboard reference is missing.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_jButton_backActionPerformed
 
    private void jButton_updateqauntityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateqauntityActionPerformed
if (selectedRow >= 0) {
            String itemName = (String) tableModel.getValueAt(selectedRow, 0);
            String itemBrand = (String) tableModel.getValueAt(selectedRow, 1);
            try {
                int newQuantity = Integer.parseInt(jTextField_quantity.getText());
                if (newQuantity > 0) {
                    if (dashboard != null && dashboard.cartItems != null) {
                        for (Product item : dashboard.cartItems) {
                            if (item.getName().equals(itemName) && item.getBrand().equals(itemBrand)) {
                                int oldQuantity = item.getSelectedQuantity();
                                for (Product p : dashboard.allProducts) {
                                    if (p.getName().equals(itemName) && p.getBrand().equals(itemBrand)) {
                                        int availableStock = p.getStockQuantity() + oldQuantity;
                                        if (availableStock >= newQuantity) {
                                            item.setSelectedQuantity(newQuantity);
                                            p.setStockQuantity(availableStock - newQuantity);
                                            dashboard.totalCartItems += (newQuantity - oldQuantity);
                                            System.out.println("Updated " + itemName + " quantity to " + newQuantity + ", Stock: " + p.getStockQuantity());
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Insufficient stock for " + itemName + "! Available: " + availableStock, "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        loadCartData();
                        JOptionPane.showMessageDialog(this, "Quantity updated successfully for " + itemName + ".", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Quantity must be positive.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_updateqauntityActionPerformed

    private void jTextField_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_quantityActionPerformed
        // TODO add your handling code here:
        jButton_updateqauntityActionPerformed(evt);

    }//GEN-LAST:event_jTextField_quantityActionPerformed

    private void jButton_loadorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loadorderActionPerformed
                                                      
        List<Product> sampleItems = new ArrayList<>();
        sampleItems.add(new Product("AC Compressor", "BrandX", 120.0, 1));
        sampleItems.add(new Product("AC Filter", "BrandY", 30.0, 1));
        this.order = new Order("ORD123", sampleItems);
        dashboard.cartItems.clear();
        loadCartData();
        JOptionPane.showMessageDialog(this, "Order loaded.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton_loadorderActionPerformed

 
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
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            List<Product> items = new ArrayList<>();
            Product laptop = new Product("Compressor", "Denso", 15000.99, 1);
            Product mouse = new Product("Condenser", "Belaso", 29.99, 2);
            items.add(laptop);
            items.add(mouse);
            Order order = new Order("ORD001", items);
            Customer sampleCustomer = new Customer("", "", "", "", "");
            CustomerDashboard dashboard = new CustomerDashboard(sampleCustomer);
            dashboard.cartItems = items;
            new ViewCart(dashboard, order).setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Remove;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_checkout;
    private javax.swing.JButton jButton_loadorder;
    private javax.swing.JButton jButton_updateqauntity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_total;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_quantity;
    // End of variables declaration//GEN-END:variables
}

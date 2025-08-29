package oopproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OrderForm extends javax.swing.JFrame {
    private Customer loggedInCustomer;
    private CustomerDashboard dashboard;

    public OrderForm(Customer customer, CustomerDashboard dashboard) {
        this.loggedInCustomer = customer;
        this.dashboard = dashboard;
        initComponents();
       jTable_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable_orders.rowAtPoint(evt.getPoint());
                int column = jTable_orders.columnAtPoint(evt.getPoint());

                if (row >= 0 && column == 3 && "Reorder".equals(jTable_orders.getValueAt(row, column))) {
                    reorder(row); // Call reorder method with the selected row
                }
            }
        });
        setLocationRelativeTo(null);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loadOrderHistory();
        
    }

    OrderForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void loadOrderHistory() {
        if (loggedInCustomer == null) {
            JOptionPane.showMessageDialog(this, "No user logged in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        loggedInCustomer.loadOrdersFromFile("orders.txt");
        List<Order> orders = loggedInCustomer.getOrderHistory();
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Order ID", "Total", "Items", "Action"},
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Only the Action column is editable
            }
        };
        jTable_orders.setModel(model);

        for (Order order : orders) {
            StringBuilder items = new StringBuilder();
            for (Product product : order.getItems()) {
                items.append(product.getName()).append(" (").append(product.getBrand())
                        .append(", Qty: ").append(product.getSelectedQuantity()).append("), ");
            }
            if (items.length() > 0) {
                items.setLength(items.length() - 2); // Remove trailing comma and space
            }
            Object[] row = {
                order.getOrderId(),
                String.format("$%.2f", order.calculateTotal()),
                items.toString(),
                "Reorder"
            };
            model.addRow(row);
        }

        if (orders.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No past orders found!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_orders = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Order History");

        jTable_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Total", "Items", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_orders);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(42, 42, 42))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reorder(int row) {
        List<Order> orders = loggedInCustomer.getOrderHistory();
        if (row < 0 || row >= orders.size()) {
            JOptionPane.showMessageDialog(this, "Invalid order selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Order selectedOrder = orders.get(row);
        List<Product> reorderedItems = new ArrayList<>();
        boolean canReorder = true;

        // Check stock availability and create new Product instances
        for (Product item : selectedOrder.getItems()) {
            for (Product stockProduct : dashboard.allProducts) {
                if (stockProduct.getName().equals(item.getName()) && stockProduct.getBrand().equals(item.getBrand())) {
                    if (stockProduct.getStockQuantity() >= item.getSelectedQuantity()) {
                        Product newItem = new Product(item.getName(), item.getBrand(), item.getPrice(), item.getStockQuantity());
                        newItem.setSelectedQuantity(item.getSelectedQuantity());
                        reorderedItems.add(newItem);
                        stockProduct.setStockQuantity(stockProduct.getStockQuantity() - item.getSelectedQuantity());
                    } else {
                        canReorder = false;
                        JOptionPane.showMessageDialog(this,
                                "Insufficient stock for " + item.getName() + " (" + item.getBrand() + "). Available: " + stockProduct.getStockQuantity(),
                                "Stock Error", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
            if (!canReorder) break;
        }

        if (canReorder) {
            Order newOrder = new Order("REORDER_" + System.currentTimeMillis(), reorderedItems);
            newOrder.setPaymentMethod(selectedOrder.getPaymentMethod());
            dashboard.cartItems.clear(); // Clear current cart
            dashboard.cartItems.addAll(reorderedItems); // Add reordered items to cart
            dashboard.totalCartItems = reorderedItems.stream().mapToInt(Product::getSelectedQuantity).sum();

            // Save the reordered order
            loggedInCustomer.addOrder(newOrder, "orders.txt");

            // Update dashboard products
            dashboard.allProducts = Product.loadFromFile("C:\\Users\\Dell\\Desktop\\Sadia\\inventory.txt");

            dashboard.showCart(); // Display the cart with reordered items
            dispose(); // Close the OrderForm
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Customer sampleCustomer = new Customer("test", "user", "test@example.com", "password", "12345");
                CustomerDashboard dashboard = new CustomerDashboard(sampleCustomer);
                OrderForm of = new OrderForm(sampleCustomer, dashboard);
                        of.setVisible(true);
                         of.pack(); // Size the frame based on its components
                         of.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_orders;
    // End of variables declaration//GEN-END:variables
}

package oopproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Admindashboard extends javax.swing.JFrame {
    private static boolean isLoggedIn = false;
    private boolean isSidebarVisible = false;
    private String adminEmail = "kashifkh";
    private String adminPassword = "ADMIN123";
    private List<Product> allProducts;
    public Admindashboard(List<Product> allProducts) {
        initComponents();
        loadProductsAndCheckStock();
        sidePanel.setPreferredSize(new Dimension(0, getHeight())); // Hide sidebar initially
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        jLabel_logo.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/autopartxpert1.jpg"))
                .getImage().getScaledInstance(jLabel_logo.getWidth(), jLabel_logo.getHeight(), Image.SCALE_SMOOTH)
        ));
        profilebutton.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/USER.jpg"))
                .getImage().getScaledInstance(profilebutton.getWidth(), profilebutton.getHeight(), Image.SCALE_SMOOTH)
        ));
    }
    private void loadProductsAndCheckStock() {
        // Load products from file (or pass from LoginForm if available)
        if (allProducts == null) {
            allProducts = Product.loadFromFile("C:\\Users\\Dell\\Desktop\\Sadia\\inventory.txt");
        }
        allProducts = Product.loadFromFile("C:\\Users\\Dell\\Desktop\\Sadia\\inventory.txt");
        
        // Check for low stock
        StringBuilder lowStockMessage = new StringBuilder("Low Stock Reminder:\n");
        boolean hasLowStock = false;
        for (Product p : allProducts) {
            if (p.getStockQuantity() <= 5) {
                hasLowStock = true;
                lowStockMessage.append("- ").append(p.getName())
                               .append(" (Brand: ").append(p.getBrand())
                               .append(") - Stock: ").append(p.getStockQuantity()).append("\n");
            }
        }

        if (hasLowStock) {
            JOptionPane.showMessageDialog(this, lowStockMessage.toString(), "Stock Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void toggleSidebar() {
        if (isSidebarVisible) {
            sidePanel.setPreferredSize(new Dimension(0, getHeight()));
        } else {
            sidePanel.setPreferredSize(new Dimension(200, getHeight()));
        }
        isSidebarVisible = !isSidebarVisible;
        sidePanel.revalidate();
        revalidate();
        repaint();
    }

    private void openProfile() {
        JDialog profileDialog = new JDialog(this, "Admin Profile", true);
        profileDialog.setSize(300, 200);
        profileDialog.setLocationRelativeTo(this);
        profileDialog.setLayout(new GridLayout(4, 2, 10, 10));
        profileDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(adminEmail, 20);
        emailField.setEditable(false);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(adminPassword, 20);
        passwordField.setEditable(false);
        JButton deleteButton = new JButton("Delete Account");
        deleteButton.addActionListener(e -> deleteAccount(profileDialog));

        profileDialog.add(emailLabel);
        profileDialog.add(emailField);
        profileDialog.add(passwordLabel);
        profileDialog.add(passwordField);
        profileDialog.add(new JLabel());
        profileDialog.add(deleteButton);

        profileDialog.setVisible(true);
        profileDialog.setVisible(true);
        profileDialog.pack();
        profileDialog.setLocationRelativeTo(this);
    }    

    private void deleteAccount(JDialog profileDialog) {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete your account? This action cannot be undone.",
                "Confirm Account Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            adminEmail = null;
            adminPassword = null;
            isLoggedIn = false;
            JOptionPane.showMessageDialog(this, "Account deleted successfully.");
            profileDialog.dispose();
            dispose();
        }
    }

    private void openModule(String module) {
        try {
            switch (module) {
                case "Analytics":
                    new AnalyticsForm().setVisible(true);
                    break;
                case "Orders":
                    Customer sampleCustomer = new Customer("admin_view", "AdminView", "admin@oop.com", "adminpass", "12345");
                    CustomerDashboard dashboard = new CustomerDashboard(sampleCustomer);
                    new OrderForm(sampleCustomer, dashboard).setVisible(true);
                    break;
                case "Supplier":
                    new SupplierForm().setVisible(true);
                    break;
                case "Inventory":
                    new InventoryForm().setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Unknown module: " + module);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error opening " + module + ": " + e.getMessage());
        }
    }

    private void handleSidebarAction(String item) {
        switch (item) {
            case "Dashboard":
                mainPanel.revalidate();
                repaint();
                JOptionPane.showMessageDialog(this, "Dashboard refreshed.");
                break;
            case "Reports":
                JDialog reportsDialog = new JDialog(this, "Reports", true);
                reportsDialog.setSize(400, 300);
                reportsDialog.setLocationRelativeTo(this);
                JTextArea reportArea = new JTextArea("Sample Report:\n- Total Orders: 150\n- Revenue: $10,000\n- Active Users: 50");
                reportArea.setEditable(false);
                reportsDialog.add(new JScrollPane(reportArea));
                reportsDialog.setVisible(true);
                break;
            case "Logout":
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    isLoggedIn = false;
                    dispose();
                }
                break;
        }
    }
    
    public static boolean adminLogin(String email, String password) {
        if ("kashifkh".equals(email) && "ADMIN123".equals(password)) {
            JOptionPane.showMessageDialog(null, "Admin Login successful!");
            isLoggedIn = true;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Admin email or password.");
            isLoggedIn = false;
            return false;
        }
    }

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jButton_analytics1 = new javax.swing.JButton();
        jButton_orders1 = new javax.swing.JButton();
        jButton_supplier = new javax.swing.JButton();
        jButton_inventory = new javax.swing.JButton();
        jLabel_logo = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        jButton_dashboard = new javax.swing.JButton();
        jButton_dashboard1 = new javax.swing.JButton();
        jButton_logout = new javax.swing.JButton();
        menuButton = new javax.swing.JButton();
        profilebutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(102, 102, 102));

        jButton_analytics1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_analytics1.setText("ANALYTICS");
        jButton_analytics1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_analytics1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_analytics1ActionPerformed(evt);
            }
        });

        jButton_orders1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_orders1.setText("ORDERS");
        jButton_orders1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_orders1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_orders1ActionPerformed(evt);
            }
        });

        jButton_supplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_supplier.setText("SUPPLIER");
        jButton_supplier.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_supplierActionPerformed(evt);
            }
        });

        jButton_inventory.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_inventory.setText("INVENTORY");
        jButton_inventory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_inventoryActionPerformed(evt);
            }
        });

        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/Logo.png"))); // NOI18N
        jLabel_logo.setText("jLabel1");
        jLabel_logo.setPreferredSize(new java.awt.Dimension(50, 50));

        jButton_dashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_dashboard.setText("Dahboard");
        jButton_dashboard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_dashboard.setDoubleBuffered(true);
        jButton_dashboard.setMaximumSize(new java.awt.Dimension(1000, 40));
        jButton_dashboard.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dashboardActionPerformed(evt);
            }
        });

        jButton_dashboard1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_dashboard1.setText("Reports");
        jButton_dashboard1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_dashboard1.setDoubleBuffered(true);
        jButton_dashboard1.setMaximumSize(new java.awt.Dimension(1000, 40));
        jButton_dashboard1.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton_dashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dashboard1ActionPerformed(evt);
            }
        });

        jButton_logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_logout.setText("Logout");
        jButton_logout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_logout.setDoubleBuffered(true);
        jButton_logout.setMaximumSize(new java.awt.Dimension(1000, 40));
        jButton_logout.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton_dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        menuButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menuButton.setText("=");
        menuButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuButton.setPreferredSize(new java.awt.Dimension(50, 50));
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        profilebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/USER.jpg"))); // NOI18N
        profilebutton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        profilebutton.setPreferredSize(new java.awt.Dimension(50, 50));
        profilebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171)
                        .addComponent(profilebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_orders1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_analytics1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_analytics1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_orders1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_analytics1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_analytics1ActionPerformed
        // TODO add your handling code here:
        AnalyticsForm analytics = new AnalyticsForm();
        analytics.setVisible(true);
    }//GEN-LAST:event_jButton_analytics1ActionPerformed

    private void jButton_orders1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_orders1ActionPerformed
        Customer sampleCustomer = new Customer("kashifkh", "AdminView", "admin@oop.com", "adminpass", "12345");
    CustomerDashboard dashboard = new CustomerDashboard(sampleCustomer);
    OrderForm orderForm = new OrderForm(sampleCustomer, dashboard); // Assign to a variable
    orderForm.pack(); // Adjust size to fit content
    orderForm.setLocationRelativeTo(this); // Center relative to the current frame
    orderForm.setVisible(true);
        
    }//GEN-LAST:event_jButton_orders1ActionPerformed

    private void jButton_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_supplierActionPerformed
        // TODO add your handling code here:
       SupplierForm supplier = new SupplierForm();
    supplier.setVisible(true);
    supplier.pack(); // Adjust size to fit content
    supplier.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton_supplierActionPerformed

    private void jButton_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_inventoryActionPerformed
        // TODO add your handling code here:
         InventoryForm IF =new InventoryForm();
          IF.setVisible(true);
          IF.pack();
          IF.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton_inventoryActionPerformed

    private void profilebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilebuttonActionPerformed
        // TODO add your handling code here:
        openProfile();
        
    }//GEN-LAST:event_profilebuttonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        // TODO add your handling code here:
        toggleSidebar();
    }//GEN-LAST:event_menuButtonActionPerformed

    private void jButton_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dashboardActionPerformed
        // TODO add your handling code here:
        handleSidebarAction("Dashboard");
    }//GEN-LAST:event_jButton_dashboardActionPerformed

    private void jButton_dashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dashboard1ActionPerformed
        // TODO add your handling code here:
        handleSidebarAction("Reports");
    }//GEN-LAST:event_jButton_dashboard1ActionPerformed

    private void jButton_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logoutActionPerformed
        // TODO add your handling code here:
        LoginForm database = new LoginForm();
        database.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(Admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            if (adminLogin("kashifkh", "ADMIN123")) {
                List<Product> products = Product.loadFromFile("C:\\Users\\Dell\\Desktop\\Sadia\\inventory.txt");
                new Admindashboard(products).setVisible(true); // Pass loaded products
            } else {
                System.exit(0);
            }
        }
        });
           
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_analytics1;
    private javax.swing.JButton jButton_dashboard;
    private javax.swing.JButton jButton_dashboard1;
    private javax.swing.JButton jButton_inventory;
    private javax.swing.JButton jButton_logout;
    private javax.swing.JButton jButton_orders1;
    private javax.swing.JButton jButton_supplier;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton profilebutton;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}

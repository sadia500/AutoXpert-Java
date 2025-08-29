package oopproject;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.*;
public class LoginForm extends javax.swing.JFrame{
    private Admin admin;
    private Customer customer;
    
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Initialize backend objects
        admin = new Admin("ADMIN001", "Owner", "000-ADMIN", "kashifkh", "ADMIN123", "Admin");
        customer = new Customer("", "", "", "", "");
        Customer.loadFromFile("customers.txt");
        // Display images on the JLabels
        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Autoxpertwallpaper.jpeg")));
        jLabel_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/USER.jpg")));
        jLabel_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/password.png")));

        // Adjust image sizes
        jLabel_logo.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/Autoxpertwallpaper.jpeg"))
                .getImage().getScaledInstance(jLabel_logo.getWidth(), jLabel_logo.getHeight(), Image.SCALE_SMOOTH)
        ));
        jLabel_user.setIcon(new ImageIcon(
                new ImageIcon(getClass().getResource("images/USER.jpg"))
                        
                .getImage().getScaledInstance(jLabel_user.getWidth(), jLabel_user.getHeight(), Image.SCALE_SMOOTH)
        ));
        jLabel_pass.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/password.png"))
                .getImage().getScaledInstance(jLabel_pass.getWidth(), jLabel_pass.getHeight(), Image.SCALE_SMOOTH)
        ));
jLabel_user.setIcon(new ImageIcon(
    new ImageIcon(getClass().getResource("images/USER.jpg"))
    .getImage().getScaledInstance(jLabel_user.getWidth(), jLabel_user.getHeight(), Image.SCALE_SMOOTH)
));
jLabel_pass.setIcon(new ImageIcon(
    new ImageIcon(getClass().getResource("images/password.png"))
    .getImage().getScaledInstance(jLabel_pass.getWidth(), jLabel_pass.getHeight(), Image.SCALE_SMOOTH)
));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_logo = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jTextField_password = new javax.swing.JPasswordField();
        jButton_close = new javax.swing.JButton();
        jLabel_user = new javax.swing.JLabel();
        jLabel_pass = new javax.swing.JLabel();
        jCheckBox_password = new javax.swing.JCheckBox();
        jLabel_ = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmb_role = new javax.swing.JComboBox<>();
        jLabel_minimize = new javax.swing.JLabel();
        jLabel_createaccount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel_logo.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/Autoxpertwallpaper.jpeg"))); // NOI18N
        jLabel_logo.setText("jLabel1");
        jLabel_logo.setOpaque(true);

        jTextField_username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField_username.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_username.setText("username");
        jTextField_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_usernameFocusLost(evt);
            }
        });
        jTextField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usernameActionPerformed(evt);
            }
        });

        jTextField_password.setText("jPasswordField1");
        jTextField_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_passwordFocusLost(evt);
            }
        });
        jTextField_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_passwordActionPerformed(evt);
            }
        });

        jButton_close.setBackground(new java.awt.Color(0, 153, 102));
        jButton_close.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_close.setForeground(new java.awt.Color(255, 255, 255));
        jButton_close.setText("Login");
        jButton_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_closeActionPerformed(evt);
            }
        });

        jLabel_user.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/USER.jpg"))); // NOI18N
        jLabel_user.setIconTextGap(0);
        jLabel_user.setOpaque(true);

        jLabel_pass.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/USER.jpg"))); // NOI18N
        jLabel_pass.setIconTextGap(0);
        jLabel_pass.setOpaque(true);

        jCheckBox_password.setText("Show Password ");
        jCheckBox_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_passwordActionPerformed(evt);
            }
        });

        jLabel_.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_.setText("x");
        jLabel_.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MouseClicked(evt);
            }
        });

        jLabel1.setText("Role");

        cmb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Customer" }));
        cmb_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_roleActionPerformed(evt);
            }
        });

        jLabel_minimize.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel_minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_minimize.setText("-");
        jLabel_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseClicked(evt);
            }
        });

        jLabel_createaccount.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel_createaccount.setText("Click here to create new account");
        jLabel_createaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_createaccountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jCheckBox_password, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jLabel_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jButton_close, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel_createaccount)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_password))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_password)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton_close, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_createaccount)
                .addContainerGap(107, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_passwordActionPerformed

    private void jTextField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usernameActionPerformed

    private void jLabel_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MouseClicked
        //To close the form 
        System.exit(0);
    }//GEN-LAST:event_jLabel_MouseClicked

    private void jTextField_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusLost
        // TODO add your handling code here:
        if(jTextField_username.getText().trim().toLowerCase().equals("username")|| 
            jTextField_username.getText().trim().toLowerCase().equals(""))
        {
            jTextField_username.setText("username");
            jTextField_username.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_jTextField_usernameFocusLost

    private void jTextField_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusGained
        //remove already written username
        if(jTextField_username.getText().trim().toLowerCase().equals("username"))
        {
            jTextField_username.setText("");
            jTextField_username.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField_usernameFocusGained

    private void jTextField_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_passwordFocusGained

        //remove already written password
        String password = String.valueOf(jTextField_password.getPassword());
        if(password.trim().toLowerCase().equals("password"))
        {
            jTextField_password.setText("");
            jTextField_password.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField_passwordFocusGained

    private void jTextField_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_passwordFocusLost
        // TODO add your handling code here:
        String password = String.valueOf(jTextField_password.getPassword());
        if(password.trim().toLowerCase().equals("password")|| 
            password.trim().toLowerCase().equals(""))
        {
            jTextField_password.setText("password");
            jTextField_password.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_jTextField_passwordFocusLost

    private void jCheckBox_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_passwordActionPerformed
        // TODO add your handling code here:
        if(jCheckBox_password.isSelected())
        {
            jTextField_password.setEchoChar((char)0);
        }
        else{
            jTextField_password.setEchoChar('*');
        }
        
    }//GEN-LAST:event_jCheckBox_passwordActionPerformed

    private void jButton_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_closeActionPerformed
   String userType = cmb_role.getSelectedItem().toString();
    String email = jTextField_username.getText().trim();
    String password = new String(jTextField_password.getPassword()).trim();

    if (email.isEmpty() || email.equals("username") || 
        password.isEmpty() || password.equals("jpasswordfield1")) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (userType.equals("Admin")) {
        if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(this, "Admin Login Successful!");
            // Load products for admin dashboard
            List<Product> allProducts = Product.loadFromFile("C:\\Users\\Dell\\Desktop\\Sadia\\inventory.txt");
            Admindashboard adminDash = new Admindashboard(allProducts); // Pass allProducts
            adminDash.setVisible(true);
            adminDash.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Admin Credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
        } else {
            try {
                Customer.getDbcustomers().clear();
                Customer.loadFromFile("customers.txt");
                System.out.println("Loaded customers, count: " + Customer.getDbcustomers().size());

                Customer loggedInCustomer = Customer.getDbcustomers().stream()
                    .filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);

                if (loggedInCustomer != null) {
                    JOptionPane.showMessageDialog(this, "Customer Login Successful!");
                    CustomerDashboard customerDash = new CustomerDashboard(loggedInCustomer);
                    customerDash.setVisible(true);
                    customerDash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                } else {
                    Customer existingCustomer = Customer.getDbcustomers().stream()
                        .filter(c -> c.getEmail().equals(email))
                        .findFirst()
                        .orElse(null);
                    if (existingCustomer != null && !existingCustomer.getPassword().equals(password)) {
                        JOptionPane.showMessageDialog(this, "Login failed. Your password has been updated. Please use your new password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Customer Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error during customer login: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton_closeActionPerformed

    private void cmb_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_roleActionPerformed

    private void jLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeMouseClicked

    private void jLabel_createaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_createaccountMouseClicked
        // TODO add your handling code here:
        
        RegisterForm rgf = new RegisterForm();
        rgf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_createaccountMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_role;
    private javax.swing.JButton jButton_close;
    private javax.swing.JCheckBox jCheckBox_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_;
    private javax.swing.JLabel jLabel_createaccount;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_minimize;
    private javax.swing.JLabel jLabel_pass;
    private javax.swing.JLabel jLabel_user;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jTextField_password;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}

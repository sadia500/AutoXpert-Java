package oopproject;
import java.awt.Color;
import java.util.Random;
import java.util.function.Predicate;
import javax.swing.*;
import oopproject.Customer;
import oopproject.LoginForm;

   
public class RegisterForm extends javax.swing.JFrame {

    public RegisterForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jTextField_password.setText("jPasswordField1");
        jTextField_email.setText("");
        jTextField_contact.setText("");
        
        //jLabel_role.setVisible(false); // Hide role field
        //jTextField_role.setVisible(false);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_minimize = new javax.swing.JLabel();
        jLabel_ = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jLabel_user = new javax.swing.JLabel();
        jTextField_password = new javax.swing.JPasswordField();
        jLabel_pass = new javax.swing.JLabel();
        jCheckBox_password = new javax.swing.JCheckBox();
        jLabel_cancel = new javax.swing.JLabel();
        jLabel_backtologin = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel_email = new javax.swing.JLabel();
        jTextField_email = new javax.swing.JTextField();
        jLabel_contact = new javax.swing.JLabel();
        jTextField_contact = new javax.swing.JTextField();
        jLabel_role = new javax.swing.JLabel();
        jTextField_role = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel_minimize.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel_minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_minimize.setText("-");
        jLabel_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_minimize);
        jLabel_minimize.setBounds(350, 0, 19, 30);

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
        jPanel1.add(jLabel_);
        jLabel_.setBounds(380, 2, 20, 32);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN-IN");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 20, 100, 30);

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
        jPanel1.add(jTextField_username);
        jTextField_username.setBounds(170, 70, 140, 40);

        jLabel_user.setText("Name");
        jPanel1.add(jLabel_user);
        jLabel_user.setBounds(90, 80, 50, 20);

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
        jPanel1.add(jTextField_password);
        jTextField_password.setBounds(170, 190, 130, 22);

        jLabel_pass.setText("Password");
        jPanel1.add(jLabel_pass);
        jLabel_pass.setBounds(90, 190, 70, 16);

        jCheckBox_password.setText("Show Password ");
        jCheckBox_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox_password);
        jCheckBox_password.setBounds(80, 220, 120, 20);

        jLabel_cancel.setBackground(new java.awt.Color(0, 102, 255));
        jLabel_cancel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel_cancel.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_cancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_cancel.setText("Cancel");
        jLabel_cancel.setOpaque(true);
        jLabel_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_cancelMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_cancel);
        jLabel_cancel.setBounds(100, 300, 90, 30);

        jLabel_backtologin.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel_backtologin.setText("Back  to Login");
        jLabel_backtologin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_backtologinMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_backtologin);
        jLabel_backtologin.setBounds(170, 360, 90, 15);

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create");
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(230, 300, 110, 30);

        jLabel_email.setText("Email");
        jPanel1.add(jLabel_email);
        jLabel_email.setBounds(90, 150, 37, 16);

        jTextField_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_emailActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_email);
        jTextField_email.setBounds(170, 150, 140, 30);

        jLabel_contact.setText("Contact");
        jPanel1.add(jLabel_contact);
        jLabel_contact.setBounds(90, 120, 50, 16);

        jTextField_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_contactActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_contact);
        jTextField_contact.setBounds(170, 120, 130, 22);

        jLabel_role.setText("Role");
        jPanel1.add(jLabel_role);
        jLabel_role.setBounds(90, 240, 40, 16);

        jTextField_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_roleActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_role);
        jTextField_role.setBounds(170, 240, 130, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 20, 400, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeMouseClicked

    private void jLabel_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MouseClicked
        //To close the form
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel_MouseClicked

    private void jTextField_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusGained
        //remove already written username
       if (jTextField_username.getText().trim().toLowerCase().equals("username")) {
            jTextField_username.setText("");
            jTextField_username.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField_usernameFocusGained

    private void jTextField_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusLost
        // TODO add your handling code here:
        if(jTextField_username.getText().trim().toLowerCase().equals("username")||
            jTextField_username.getText().trim().toLowerCase().equals(""))
        {
            jTextField_username.setText("username");
            jTextField_username.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_jTextField_usernameFocusLost

    private void jTextField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usernameActionPerformed

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
        String password = String.valueOf(jTextField_password.getPassword());
        if (password.trim().toLowerCase().equals("password") ||
            password.trim().toLowerCase().equals("")) {
            jTextField_password.setText("password");
            jTextField_password.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextField_passwordFocusLost

    private void jTextField_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_passwordActionPerformed

    private void jCheckBox_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_passwordActionPerformed
        // TODO add your handling code her
   if (jCheckBox_password.isSelected()) {
            jTextField_password.setEchoChar((char) 0);
        } else {
            jTextField_password.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox_passwordActionPerformed

    private void jLabel_backtologinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_backtologinMouseClicked
        // TODO add your handling code here:
        LoginForm lgf = new LoginForm();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel_backtologinMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // Load customers from file
        Customer.loadFromFile("customers.txt");

        String username = jTextField_username.getText().trim();
        String contact = jTextField_contact.getText().trim();
        String email = jTextField_email.getText().trim();
        String password = new String(jTextField_password.getPassword()).trim();

        // Validate input
        if (username.isEmpty() || username.equals("username") ||
            contact.isEmpty() || email.isEmpty() ||
            password.isEmpty() || password.equals("jpasswordfield1")) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Generate unique userID
        String userID;
        try {
            userID = Customer.generateUniqueUserID();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create new Customer
        Customer newCustomer = new Customer(userID, username, contact, email, password);
        Customer.getDbcustomers().add(newCustomer);

        // Save to file
        try {
            newCustomer.saveToFile("customers.txt");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Provide feedback
        JOptionPane.showMessageDialog(this, "Account created successfully! UserID: " + userID + "\nPlease login with your email and password.", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Navigate back to LoginForm
        LoginForm lgf = new LoginForm();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_emailActionPerformed

    private void jTextField_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_contactActionPerformed

    private void jTextField_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_roleActionPerformed

    private void jLabel_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_cancelMouseClicked
        // TODO add your handling code here:
        LoginForm lgf = new LoginForm();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel_cancelMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
    
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_;
    private javax.swing.JLabel jLabel_backtologin;
    private javax.swing.JLabel jLabel_cancel;
    private javax.swing.JLabel jLabel_contact;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_minimize;
    private javax.swing.JLabel jLabel_pass;
    private javax.swing.JLabel jLabel_role;
    private javax.swing.JLabel jLabel_user;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_contact;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JPasswordField jTextField_password;
    private javax.swing.JTextField jTextField_role;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}                                

  
    
        

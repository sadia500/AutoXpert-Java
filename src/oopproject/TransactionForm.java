package oopproject;
import java.awt.Graphics2D;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oopproject.CustomerDashboard;
import oopproject.Invoice;
import oopproject.Transaction;

public class TransactionForm extends javax.swing.JFrame {
    private Transaction transaction;
    private Customer customer;
    private Invoice invoice;

    public TransactionForm(Transaction transaction, Invoice invoice) {
        this.transaction = transaction;
        this.invoice = invoice;
        try {
            initComponents();
            setLocationRelativeTo(null);
            this.setSize(400, 600);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            if (transaction != null) {
                loadTransactionData();
            } else {
                JOptionPane.showMessageDialog(this, "No transaction data provided!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (invoice != null) {
                loadInvoiceData();
            } else {
                jTextArea_receipt.setText("No invoice data available.");
            }
        } catch (Exception e) {
            System.err.println("Error initializing TransactionForm: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadTransactionData() {
        jLabel_transactionID.setText("Transaction ID: " + transaction.getTransactionID());
        jLabel_method.setText("Method: " + transaction.getPaymentMethod());
        jLabel_amount.setText("Amount: $" + String.format("%.2f", transaction.getAmount()));
        jLabel_dateTime.setText("Date/Time: " + transaction.getDateTime().toString());
    }

    private void loadInvoiceData() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Receipt:\n");
        receipt.append("-------------------------\n");
        receipt.append("Store: AutoXpert\n");
        receipt.append("Receipt No: RCPT").append(System.currentTimeMillis()).append("\n");
        receipt.append("Transaction ID: ").append(transaction.getTransactionID()).append("\n");
        receipt.append("Method: ").append(transaction.getPaymentMethod()).append("\n");
        receipt.append("Amount: $").append(String.format("%.2f", transaction.getAmount())).append("\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        receipt.append("Date/Time: ").append(transaction.getDateTime().format(formatter)).append("\n");
        receipt.append("Customer: ").append(invoice.getCustomerName()).append("\n");
        receipt.append("Items:\n");
        for (String item : invoice.getItems()) {
            receipt.append("- ").append(item).append("\n");
        }
        receipt.append("Tax (5%): $").append(String.format("%.2f", invoice.getTotalAmount() * 0.05)).append("\n");
        receipt.append("Total: $").append(String.format("%.2f", invoice.getTotalAmount())).append("\n");
        receipt.append("-------------------------\n");
        receipt.append("Thank You for Shopping!");
        jTextArea_receipt.setText(receipt.toString());
        jTextArea_receipt.setCaretPosition(0);
    }

    // [UPDATE] Complete and fix the saveTransactionData method
    private void saveTransactionData() {
        File file = new File("transactions.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Created new transactions file: " + file.getAbsolutePath());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                StringBuilder line = new StringBuilder();
                line.append(transaction.getTransactionID()).append(",")
                    .append(transaction.getPaymentMethod()).append(",")
                    .append(transaction.getAmount()).append(",")
                    .append(transaction.getDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))).append(",")
                    .append(invoice.getCustomerName()).append(",");
                for (String item : invoice.getItems()) {
                    line.append(item).append("|");
                }
                writer.write(line.toString());
                writer.newLine();
                System.out.println("Saved transaction: " + line.toString() + " to " + file.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Transaction saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel_transactionID = new javax.swing.JLabel();
        jLabel_method = new javax.swing.JLabel();
        jLabel_amount = new javax.swing.JLabel();
        jLabel_dateTime = new javax.swing.JLabel();
        jButton_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_receipt = new javax.swing.JTextArea();
        jButton_print = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N

        jLabel_transactionID.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel_transactionID.setText("Transaction ID: ");

        jLabel_method.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel_method.setText("Method: ");

        jLabel_amount.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel_amount.setText("Amount: ");

        jLabel_dateTime.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel_dateTime.setText("DateTime: ");

        jButton_back.setBackground(new java.awt.Color(30, 136, 229));
        jButton_back.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton_back.setForeground(new java.awt.Color(255, 255, 255));
        jButton_back.setText("Back");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        jTextArea_receipt.setColumns(20);
        jTextArea_receipt.setRows(5);
        jScrollPane1.setViewportView(jTextArea_receipt);

        jButton_print.setBackground(new java.awt.Color(30, 136, 229));
        jButton_print.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton_print.setForeground(new java.awt.Color(255, 255, 255));
        jButton_print.setText("Print");
        jButton_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_printActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setText("Transaction Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_transactionID)
                            .addComponent(jLabel_method)
                            .addComponent(jLabel_amount)
                            .addComponent(jLabel_dateTime)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel_transactionID)
                .addGap(18, 18, 18)
                .addComponent(jLabel_method)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_amount)
                .addGap(18, 18, 18)
                .addComponent(jLabel_dateTime)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_back)
                            .addComponent(jButton_print))
                        .addGap(38, 38, 38))))
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

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
       saveTransactionData(); // Save the transaction data
        try {
            CustomerDashboard dashboard = new CustomerDashboard(customer); // Assuming customer is set
            dashboard.setVisible(true);
            
        } catch (Exception e) {
            System.err.println("Error opening CustomerDashboard: " + e.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

    private void jButton_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_printActionPerformed
 saveTransactionData(); // Save the transaction data
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable((graphics, pageFormat, pageIndex) -> {
                if (pageIndex > 0) return Printable.NO_SUCH_PAGE;
                Graphics2D g2 = (Graphics2D) graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2.drawString("AutoXpert Receipt", 100, 50);
                g2.drawString("Receipt No: RCPT" + System.currentTimeMillis(), 100, 80);
                g2.drawString("Transaction ID: " + transaction.getTransactionID(), 100, 110);
                g2.drawString("Method: " + transaction.getPaymentMethod(), 100, 140);
                g2.drawString("Amount: $" + String.format("%.2f", transaction.getAmount()), 100, 170);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                g2.drawString("Date/Time: " + transaction.getDateTime().format(formatter), 100, 200);
                g2.drawString("Customer: " + invoice.getCustomerName(), 100, 230);
                g2.drawString("Items: ", 100, 260);
                int y = 290;
                for (String item : invoice.getItems()) {
                    g2.drawString("- " + item, 100, y);
                    y += 30;
                }
                g2.drawString("Tax (5%): $" + String.format("%.2f", invoice.getTotalAmount() * 0.05), 100, y);
                g2.drawString("Total: $" + String.format("%.2f", invoice.getTotalAmount()), 100, y + 30);
                g2.drawString("Thank You for Shopping!", 100, y + 60);
                return Printable.PAGE_EXISTS;
            });
            if (job.printDialog()) {
                job.print();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Printing failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_printActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
           Transaction sample = new Transaction("TX123", "Credit Card", 150.00, LocalDateTime.now());
            Invoice sampleInvoice = new Invoice("John Doe", 
                Arrays.asList("AC Compressor (x2) - $120.00", "AC Filter (x1) - $30.00"), 
                150.00);
            new TransactionForm(sample, sampleInvoice).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_print;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_amount;
    private javax.swing.JLabel jLabel_dateTime;
    private javax.swing.JLabel jLabel_method;
    private javax.swing.JLabel jLabel_transactionID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_receipt;
    // End of variables declaration//GEN-END:variables
}

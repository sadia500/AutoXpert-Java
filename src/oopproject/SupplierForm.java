package oopproject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierForm extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private static final String FILE_PATH = "C:\\Users\\Dell\\Desktop\\Sadia\\supplier.txt";

    public SupplierForm() {
        initComponents();
        setLocationRelativeTo(null); // Centers on screen
        setSize(800, 600); // Set symmetry size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setupTable();
        initializeFile();
        loadSuppliers();
    }

    private void initializeFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs(); // Create directory if it doesn't exist
                file.createNewFile(); // Create the file
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write("S001,Imran Ali,imranali25@gmail.com,03327487527,Product1,Product2");
                    bw.newLine();
                    bw.write("S002,Amir Mughal,amirm234@gmail.com,03174840684,Product3");
                    bw.newLine();
                    bw.write("S003,Qamar Khan,khanqamar5@gmail.com,0336477854,Product4,Product5");
                    bw.newLine();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error creating file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void setupTable() {
        if (supplierTable == null) {
            JOptionPane.showMessageDialog(this, "Table component not initialized!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Supplier ID", "Name", "Email", "Phone", "Products", "Restock", "Contact"}
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 5) return Boolean.class; // Restock column
                if (columnIndex == 6) return JButton.class; // Contact column
                return Object.class; // Flexible for Products (List<String> or String)
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 5 || column == 6; // Editable: Products, Restock, Contact
            }
        };
        supplierTable.setModel(tableModel);
        supplierTable.getColumnModel().getColumn(0).setPreferredWidth(150); // Supplier ID
        supplierTable.getColumnModel().getColumn(1).setPreferredWidth(200); // Name
        supplierTable.getColumnModel().getColumn(2).setPreferredWidth(200); // Email
        supplierTable.getColumnModel().getColumn(3).setPreferredWidth(150); // Phone
        supplierTable.getColumnModel().getColumn(4).setPreferredWidth(350); // Products
        supplierTable.getColumnModel().getColumn(5).setPreferredWidth(150); // Restock
        supplierTable.getColumnModel().getColumn(6).setPreferredWidth(200); // Contact
        supplierTable.setRowHeight(30);
        supplierTable.setAutoCreateRowSorter(true);

        // Custom renderer for "Restock" column
        supplierTable.getColumn("Restock").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected(value != null && (Boolean) value);
                checkBox.setHorizontalAlignment(JLabel.CENTER);
                return checkBox;
            }
        });
        supplierTable.getColumn("Restock").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public boolean stopCellEditing() {
                int row = supplierTable.getEditingRow();
                boolean newValue = ((JCheckBox) getComponent()).isSelected();
                tableModel.setValueAt(newValue, row, 5);
                saveSuppliers();
                return super.stopCellEditing();
            }
        });

        // Custom renderer and editor for "Products" column
        supplierTable.getColumn("Products").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                String displayValue = "";
                if (value instanceof List) {
                    displayValue = String.join(", ", (List<String>) value);
                } else if (value != null) {
                    displayValue = value.toString();
                }
                return super.getTableCellRendererComponent(table, displayValue, isSelected, hasFocus, row, column);
            }
        });
        supplierTable.getColumn("Products").setCellEditor(new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean stopCellEditing() {
                int row = supplierTable.getEditingRow();
                String newValue = (String) getCellEditorValue();
                List<String> products = new ArrayList<>();
                if (newValue != null && !newValue.trim().isEmpty()) {
                    for (String product : newValue.split(",")) {
                        products.add(product.trim());
                    }
                }
                tableModel.setValueAt(products.isEmpty() ? "" : products, row, 4); // Use empty string if no products
                saveSuppliers();
                return super.stopCellEditing();
            }
        });

        // Custom renderer and editor for "Contact" button column
        supplierTable.getColumn("Contact").setCellRenderer(new ButtonRenderer());
        supplierTable.getColumn("Contact").setCellEditor(new ButtonEditor(new JCheckBox()));
    }

    private void loadSuppliers() {
        if (supplierTable == null) {
            JOptionPane.showMessageDialog(this, "Table component not initialized!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            tableModel.setRowCount(0); // Clear existing rows
            File file = new File(FILE_PATH);
            List<Supplier> suppliers = loadSuppliersFromFile(file);
            for (Supplier supplier : suppliers) {
                boolean restock = false; // Default value
                tableModel.addRow(new Object[]{
                    supplier.getSupplierID(),
                    supplier.getSupplierName(),
                    supplier.getEmail(),
                    supplier.getPhone(),
                    supplier.getProducts(),
                    restock,
                    "Contact Supplier"
                });
            }
            if (suppliers.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No suppliers found in file.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading suppliers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private List<Supplier> loadSuppliersFromFile(File file) throws IOException {
        List<Supplier> suppliers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String phone = parts[3].trim();
                    List<String> products = new ArrayList<>();
                    for (int i = 4; i < parts.length; i++) {
                        if (!parts[i].trim().isEmpty()) {
                            products.add(parts[i].trim());
                        }
                    }
                    suppliers.add(new Supplier(id, name, email, phone, products));
                }
            }
        }
        return suppliers;
    }

    private void saveSuppliers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String supplierID = (String) tableModel.getValueAt(i, 0);
                String name = (String) tableModel.getValueAt(i, 1);
                String email = (String) tableModel.getValueAt(i, 2);
                String phone = (String) tableModel.getValueAt(i, 3);
                Object productsObj = tableModel.getValueAt(i, 4);
                String productsStr = "";
                if (productsObj instanceof List) {
                    List<String> products = (List<String>) productsObj;
                    productsStr = products != null && !products.isEmpty() ? String.join(",", products) : "";
                } else if (productsObj != null) {
                    productsStr = productsObj.toString();
                }
                bw.write(String.format("%s,%s,%s,%s,%s", supplierID, name, email, phone, productsStr));
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Suppliers saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving suppliers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void addSupplier() {
        JDialog addDialog = new JDialog(this, "Add New Supplier", true);
        addDialog.setSize(300, 250);
        addDialog.setLayout(new GridLayout(6, 2, 10, 10));
        addDialog.setLocationRelativeTo(this);

        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        JTextField phoneField = new JTextField(15);
        JTextField productsField = new JTextField(15);

        addDialog.add(new JLabel("Supplier ID:"));
        addDialog.add(idField);
        addDialog.add(new JLabel("Name:"));
        addDialog.add(nameField);
        addDialog.add(new JLabel("Email:"));
        addDialog.add(emailField);
        addDialog.add(new JLabel("Phone:"));
        addDialog.add(phoneField);
        addDialog.add(new JLabel("Products:"));
        addDialog.add(productsField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String productsStr = productsField.getText().trim();
            List<String> products = new ArrayList<>();
            if (!productsStr.isEmpty()) {
                for (String product : productsStr.split(",")) {
                    products.add(product.trim());
                }
            }

            if (id.isEmpty() || name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(addDialog, "All fields except products are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if supplier ID already exists
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(id)) {
                    JOptionPane.showMessageDialog(addDialog, "Supplier ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                bw.write(String.format("%s,%s,%s,%s,%s", id, name, email, phone, String.join(",", products)));
                bw.newLine();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(addDialog, "Error saving new supplier: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                return;
            }

            tableModel.addRow(new Object[]{id, name, email, phone, products, false, "Contact Supplier"});
            addDialog.dispose();
        });

        addDialog.add(new JLabel());
        addDialog.add(saveButton);
        addDialog.setVisible(true);
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Contact Supplier" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;
        private int row;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener((ActionEvent e) -> {
                fireEditingStopped();
                String supplierID = (String) tableModel.getValueAt(row, 0);
                String email = (String) tableModel.getValueAt(row, 2);
                String phone = (String) tableModel.getValueAt(row, 3);
                Boolean restock = (Boolean) tableModel.getValueAt(row, 5);
                if (restock) {
                    JOptionPane.showMessageDialog(
                            SupplierForm.this,
                            String.format("Contact Supplier %s\nEmail: %s\nPhone: %s", supplierID, email, phone),
                            "Restock Needed",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            SupplierForm.this,
                            "No restock needed for Supplier " + supplierID,
                            "Info",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            label = (value == null) ? "Contact Supplier" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    // Basic Supplier class to resolve compilation errors
    static class Supplier {
        private String supplierID;
        private String supplierName;
        private String email;
        private String phone;
        private List<String> products;

        public Supplier(String supplierID, String supplierName, String email, String phone, List<String> products) {
            this.supplierID = supplierID;
            this.supplierName = supplierName;
            this.email = email;
            this.phone = phone;
            this.products = products != null ? new ArrayList<>(products) : new ArrayList<>();
        }

        public String getSupplierID() { return supplierID; }
        public String getSupplierName() { return supplierName; }
        public String getEmail() { return email; }
        public String getPhone() { return phone; }
        public List<String> getProducts() { return new ArrayList<>(products); }

        public static List<Supplier> loadFromFile(File file) throws IOException {
            return new SupplierForm().loadSuppliersFromFile(file); // Delegate to instance method
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        jButton_addsupplier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        supplierTable.setAutoCreateRowSorter(true);
        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Name", "Email", "Phone", "Products", "Needs Restock", "Contact for Restock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        supplierTable.setRowHeight(30);
        jScrollPane1.setViewportView(supplierTable);

        titleLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        titleLabel.setText("SUPPLIER DEATILS");

        refreshButton.setText("REFRESH");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        jButton_addsupplier.setText("Add Supplier");
        jButton_addsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addsupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_addsupplier)
                .addGap(76, 76, 76)
                .addComponent(refreshButton)
                .addGap(150, 150, 150))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(jButton_addsupplier))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
       loadSuppliers();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void jButton_addsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addsupplierActionPerformed
        // TODO add your handling code here:
        addSupplier();
    }//GEN-LAST:event_jButton_addsupplierActionPerformed

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
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
        SupplierForm sf = new SupplierForm(); // Create the instance
        sf.pack(); // Size the frame based on its components
        sf.setLocationRelativeTo(null); // Center relative to the screen (use 'null' if no specific parent)
        sf.setVisible(true); // Display the frame
    }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_addsupplier;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable supplierTable;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

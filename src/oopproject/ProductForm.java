package oopproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import java.util.List;
import oopproject.Product;

public class ProductForm extends javax.swing.JFrame {
private Customer customer;
    public ProductForm() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            loadProductsToTable("products.txt");  // Specify full path if needed
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
        }
    }

    public void loadProductsToTable(String filename) throws Exception {
        List<Product> products = Product.loadFromFile(filename);

        String[] columns = {"Product ID", "Name", "Brand", "Price", "Stock"};

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Product p : products) {
            Object[] row = {
                p.getProductID(),
                p.getName(),
                p.getBrand(),
                p.getPrice(),
                p.getStockQuantity()
            };
            model.addRow(row);
        }

        productTable.setModel(model);
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        productTable = new JTable();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        productTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Product ID", "Product Name", "Product Brand", "Price", "Stock Quantity"}
        ));
        jScrollPane1.setViewportView(productTable);

        jButton1.setText("Back");
        jButton1.addActionListener(evt -> {
            this.setVisible(false);
            CustomerDashboard dashboard = new CustomerDashboard(customer);
            dashboard.setVisible(true);
            this.dispose();
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(217, 217, 217))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(0, 114, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> new ProductForm().setVisible(true));
    }

    // Variables declaration
    private JButton jButton1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable productTable;
}

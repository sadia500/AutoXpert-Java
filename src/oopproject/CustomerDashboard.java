package oopproject;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import oopproject.Customer;
import oopproject.Product;
import oopproject.ProfileDetail;

public class CustomerDashboard extends javax.swing.JFrame {
    Customer loggedInCustomer;
    private List<Product> orderItems = new ArrayList<>();
    protected List<Product> allProducts;
    protected List<Product> filteredProducts;
    protected List<Product> cartItems = new ArrayList<>();
    protected int totalCartItems = 0;
    private void initializeSampleProducts() {
    allProducts = new ArrayList<>();
    // Add sample products
    allProducts.add(new Product("Cooling Coil", "Denso", 149.99, 30));
    allProducts.add(new Product("Cooling Coil", "Spectra Premium", 130.99, 25));
    allProducts.add(new Product("Cooling Coil", "Four Seasons", 170.99, 20));
    allProducts.add(new Product("Cooling Coil", "UAC Sanden", 140.99, 22));
    allProducts.add(new Product("Cooling Coil", "Valeo", 160.99, 18));
    allProducts.add(new Product("Compressor", "Denso", 299.99, 20));
    allProducts.add(new Product("Compressor", "Spectra Premium", 250.99, 15));
    allProducts.add(new Product("Compressor", "Four Seasons", 320.99, 10));
    allProducts.add(new Product("Compressor", "UAC Sanden", 280.99, 12));
    allProducts.add(new Product("Compressor", "Valeo", 300.99, 18));
    allProducts.add(new Product("Condenser", "Valeo", 199.99, 15));
    allProducts.add(new Product("Condenser", "Denso", 199.99, 15));
    allProducts.add(new Product("Condenser", "Spectra Premium", 180.99, 20));
    allProducts.add(new Product("Condenser", "Four Seasons", 220.99, 10));
    allProducts.add(new Product("Condenser", "UAC Sanden", 190.99, 14));
    
    filteredProducts = new ArrayList<>(allProducts);
}
   
    ///////////////////////
    public CustomerDashboard(Customer customer) {
        this.loggedInCustomer = customer;
        initComponents();
        setLocationRelativeTo(null);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        initializeSampleProducts(); 
        
        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/autopartxpert1.jpg")));
         jLabel_logo.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/autopartxpert1.jpg"))
                .getImage().getScaledInstance(jLabel_logo.getWidth(), jLabel_logo.getHeight(), Image.SCALE_SMOOTH)
        ));
        jLabel_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/USER.jpg")));
        jLabel_profile.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/USER.jpg"))
            .getImage().getScaledInstance(jLabel_profile.getWidth(), jLabel_profile.getHeight(), Image.SCALE_SMOOTH)
        ));
        jLabel_condensor.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/condensor.jpg")));
         jLabel_condensor.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/condensor.jpg"))
                .getImage().getScaledInstance(jLabel_logo.getWidth(), jLabel_logo.getHeight(), Image.SCALE_SMOOTH)
        ));
         jLabel_coolingcoil.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/coolingcoil.jpg")));
         jLabel_coolingcoil.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/coolingcoil.jpg"))
                .getImage().getScaledInstance(jLabel_logo.getWidth(), jLabel_logo.getHeight(), Image.SCALE_SMOOTH)
        ));
        jLabel_compressor.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/compressor.jpeg")));
         jLabel_compressor.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/compressor.jpeg"))
                .getImage().getScaledInstance(jLabel_logo.getWidth(), jLabel_logo.getHeight(), Image.SCALE_SMOOTH)
        ));
        jLabel_cart.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/cart.png")));
        jLabel_cart.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("images/cart.png"))
            .getImage().getScaledInstance(jLabel_profile.getWidth(), jLabel_profile.getHeight(), Image.SCALE_SMOOTH)
        ));
        jTextField_searchbar.setText("Search for Car AC Parts...");
    jTextField_searchbar.setForeground(new java.awt.Color(153, 153, 153)); // Gray placeholder
    jTextField_searchbar.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (jTextField_searchbar.getText().equals("Search for Car AC Parts...")) {
                jTextField_searchbar.setText("");
                jTextField_searchbar.setForeground(new java.awt.Color(0, 0, 0)); // Black for user input
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (jTextField_searchbar.getText().isEmpty()) {
                jTextField_searchbar.setText("Search for Car AC Parts...");
                jTextField_searchbar.setForeground(new java.awt.Color(153, 153, 153)); // Restore gray
            }
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_sidepanel = new javax.swing.JPanel();
        jTextField_searchbar = new javax.swing.JTextField();
        jLabel_cart = new javax.swing.JLabel();
        jLabel_profile = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_logo = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton_search = new javax.swing.JButton();
        jButton_Backtologin = new javax.swing.JButton();
        jButton_compressor = new javax.swing.JButton();
        jLabel_coolingcoil = new javax.swing.JLabel();
        jButton_Condensor = new javax.swing.JButton();
        jLabel_compressor = new javax.swing.JLabel();
        jLabel_condensor = new javax.swing.JLabel();
        jButton_coolingcoil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel_sidepanel.setBackground(new java.awt.Color(204, 204, 204));

        jTextField_searchbar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextField_searchbar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_searchbar.setText("Search for Car AC Parts                                                                        ");
        jTextField_searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_searchbarActionPerformed(evt);
            }
        });

        jLabel_cart.setBackground(new java.awt.Color(153, 255, 255));
        jLabel_cart.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel_cart.setText("View Cart");
        jLabel_cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_cartMouseClicked(evt);
            }
        });

        jLabel_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/USER.jpg"))); // NOI18N
        jLabel_profile.setText(" ");
        jLabel_profile.setOpaque(true);
        jLabel_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_profileMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(50, 50, 50));
        jPanel3.setLayout(null);

        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/autopartxpert1.jpg"))); // NOI18N
        jLabel_logo.setText("jLabel3");
        jLabel_logo.setOpaque(true);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton_search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_search.setText("Search");
        jButton_search.setOpaque(true);
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        jButton_Backtologin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Backtologin.setText("Logout");
        jButton_Backtologin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BacktologinActionPerformed(evt);
            }
        });

        jButton_compressor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_compressor.setText("Compressors");
        jButton_compressor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_compressorActionPerformed(evt);
            }
        });

        jLabel_coolingcoil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_coolingcoil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/coolingcoil.jpg"))); // NOI18N
        jLabel_coolingcoil.setFocusable(false);
        jLabel_coolingcoil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_coolingcoil.setOpaque(true);

        jButton_Condensor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Condensor.setText("Condensor");
        jButton_Condensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CondensorActionPerformed(evt);
            }
        });

        jLabel_compressor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_compressor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/compressor.jpeg"))); // NOI18N
        jLabel_compressor.setText(" ");
        jLabel_compressor.setFocusable(false);
        jLabel_compressor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_compressor.setOpaque(true);

        jLabel_condensor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_condensor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopproject/Images/condensor.jpg"))); // NOI18N
        jLabel_condensor.setFocusable(false);
        jLabel_condensor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_condensor.setOpaque(true);

        jButton_coolingcoil.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_coolingcoil.setText("Cooling coil");
        jButton_coolingcoil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_coolingcoilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_sidepanelLayout = new javax.swing.GroupLayout(jPanel_sidepanel);
        jPanel_sidepanel.setLayout(jPanel_sidepanelLayout);
        jPanel_sidepanelLayout.setHorizontalGroup(
            jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                        .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jTextField_searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                                .addComponent(jLabel_compressor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145)
                                .addComponent(jLabel_condensor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_search)
                        .addGap(0, 127, Short.MAX_VALUE))
                    .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                        .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_Backtologin)
                            .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton_compressor))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(jButton_Condensor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_coolingcoil, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_sidepanelLayout.createSequentialGroup()
                                        .addComponent(jButton_coolingcoil)
                                        .addGap(24, 24, 24)))
                                .addGap(54, 54, 54))
                            .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                                .addComponent(jLabel_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel_sidepanelLayout.setVerticalGroup(
            jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_compressor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_condensor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_coolingcoil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_compressor)
                    .addComponent(jButton_Condensor)
                    .addComponent(jButton_coolingcoil))
                .addGroup(jPanel_sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_sidepanelLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jButton_Backtologin)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_sidepanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_sidepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_sidepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// </editor-fold>                        

    private void performSearch() {
        String searchTerm = jTextField_searchbar.getText().trim().toLowerCase();
        if (searchTerm.isEmpty() || searchTerm.equals("search for car ac parts...")) {
            JOptionPane.showMessageDialog(this, "Please enter a search term!", "Empty Search", JOptionPane.WARNING_MESSAGE);
            return;
        }

        filteredProducts.clear();
        for (Product product : allProducts) {
            String productName = product.getName() != null ? product.getName().trim().toLowerCase() : "";
            String productBrand = product.getBrand() != null ? product.getBrand().trim().toLowerCase() : "";
            if (productName.contains(searchTerm) || productBrand.contains(searchTerm)) {
                filteredProducts.add(product);
            }
        }

        if (filteredProducts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No products found for: \"" + searchTerm + "\"", "No Results", JOptionPane.INFORMATION_MESSAGE);
        } else {
            displaySearchResults();
        }
    }
    
    private void jTextField_searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_searchbarActionPerformed
 performSearch();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_searchbarActionPerformed

    private void jLabel_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_profileMouseClicked
        // TODO add your handling code here:
    if (loggedInCustomer != null) {
        ProfileDetail profileDetail = new ProfileDetail(loggedInCustomer, this); // Pass this dashboard
        profileDetail.setVisible(true);
        // Optionally hide this dashboard: setVisible(false); or dispose();
    } else {
        JOptionPane.showMessageDialog(this, "No user logged in!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jLabel_profileMouseClicked

    void showCart() {
    if (cartItems.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Your cart is empty!", "Empty Cart", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    JFrame cartFrame = new JFrame("Shopping Cart - " + totalCartItems + " items");
    cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    cartFrame.setSize(700, 400);
    cartFrame.setLocationRelativeTo(this);

    String[] columns = {"Product Name", "Category", "Price", "Quantity", "Subtotal", "Remove"};
    DefaultTableModel cartModel = new DefaultTableModel(columns, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 5;
        }
    };

    double grandTotal = 0;
    for (Product item : cartItems) {
        double subtotal = item.getPrice() * item.getSelectedQuantity();
        grandTotal += subtotal;

        Object[] row = {
            item.getName(),
            item.getBrand(),
            "$" + String.format("%.2f", item.getPrice()),
            item.getSelectedQuantity(),
            "$" + String.format("%.2f", subtotal),
            "Remove"
        };
        cartModel.addRow(row);
    }

    JTable cartTable = new JTable(cartModel);
    cartTable.setRowHeight(30);

    cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = cartTable.getSelectedRow();
            int column = cartTable.getSelectedColumn();

            if (column == 5 && row >= 0) {
                Product itemToRemove = cartItems.get(row);
                totalCartItems -= itemToRemove.getSelectedQuantity();
                cartItems.remove(row);
                cartFrame.dispose();
                showCart();
            }
        }
    });

    JScrollPane scrollPane = new JScrollPane(cartTable);
    cartFrame.add(scrollPane, BorderLayout.CENTER);

    JPanel controlPanel = new JPanel();
    JButton proceedToCheckout = new JButton("Proceed to Checkout");
    proceedToCheckout.addActionListener(e -> {
        if (loggedInCustomer == null) {
            System.err.println("Error: loggedInCustomer is null in CustomerDashboard");
            JOptionPane.showMessageDialog(this, "No customer logged in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Order order = new Order("CART_" + System.currentTimeMillis(), new ArrayList<>(cartItems));
        PaymentForm paymentForm = new PaymentForm(order, this, null, loggedInCustomer); // Explicitly pass loggedInCustomer
        paymentForm.setVisible(true);
        paymentForm.pack();
        paymentForm.setLocationRelativeTo(this);
        cartFrame.dispose();
    });
    controlPanel.add(proceedToCheckout);
    cartFrame.add(controlPanel, BorderLayout.SOUTH);

    cartFrame.setVisible(true);
}
    public Customer getLoggedInCustomer() {
    return loggedInCustomer;
}
void addToCart(Product product, int quantity) {
    System.out.println("Adding to cart: " + product.getName() + " (Brand: " + product.getBrand() + "), Quantity: " + quantity);
    System.out.println("Current cartItems size: " + cartItems.size() + ", Contents: " + cartItems);
    
    boolean found = false;
    for (Product cartItem : cartItems) {
        if (cartItem.getName().equals(product.getName()) && cartItem.getBrand().equals(product.getBrand())) {
            cartItem.setSelectedQuantity(cartItem.getSelectedQuantity() + quantity); // Update selected quantity
            found = true;
            System.out.println("Updated existing item: " + cartItem.getName() + ", New Selected Qty: " + cartItem.getSelectedQuantity());
            break;
        }
    }
    
    if (!found) {
        for (Product origProduct : allProducts) {
            if (origProduct.getName().equals(product.getName()) && origProduct.getBrand().equals(product.getBrand())) {
                Product cartProduct = new Product(origProduct.getName(), origProduct.getBrand(), origProduct.getPrice(), origProduct.getStockQuantity());
                cartProduct.setSelectedQuantity(quantity); // Set initial selected quantity
                cartItems.add(cartProduct); // Add new instance for cart
                System.out.println("Added new item: " + cartProduct.getName() + " (Brand: " + cartProduct.getBrand() + "), Selected Qty: " + quantity);
                break;
            }
        }
    }
    
    
    totalCartItems += quantity;
    System.out.println("New cartItems size: " + cartItems.size() + ", Contents: " + cartItems);
    
    JOptionPane.showMessageDialog(this,
        quantity + " x " + product.getName() + " added to cart!\n" +
        "Total cart items: " + totalCartItems,
        "Added to Cart",
        JOptionPane.INFORMATION_MESSAGE);
}

private void displaySearchResults() {
        JFrame resultsFrame = new JFrame("Search Results - " + filteredProducts.size() + " products found");
        resultsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultsFrame.setSize(900, 500);
        resultsFrame.setLocationRelativeTo(this);
        
        System.out.println("Filtered products: " + filteredProducts.size());
        for (Product p : filteredProducts) {
            System.out.println(p.getName());
        }
        
        String[] columns = {"ID", "Product Name", "Brand", "Price", "Stock Qty", "Add to Cart"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        for (Product product : filteredProducts) {
            Object[] row = {
                product.getProductID(),
                product.getName(),
                product.getBrand(),
                "$" + String.format("%.2f", product.getPrice()),
                product.getStockQuantity() > 0 ? product.getStockQuantity() + " in stock" : "Out of Stock",
                "Add to Cart"
            };
            model.addRow(row);
        }
        
        JTable table = new JTable(model);
        table.setRowHeight(40);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = new JButton(value.toString());
                return button;
            }
        });
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int column = table.columnAtPoint(evt.getPoint());
                
                if (row >= 0 && row < table.getRowCount() && column == 5) {
                    try {
                        Product selectedProduct = filteredProducts.get(row);
                        int qtyToAdd = 1;
                        
                        if (qtyToAdd > selectedProduct.getStockQuantity()) {
                            JOptionPane.showMessageDialog(resultsFrame, 
                                "Not enough stock! Available: " + selectedProduct.getStockQuantity(), 
                                "Insufficient Stock", 
                                JOptionPane.WARNING_MESSAGE);
                            return;
                        }
addToCart(selectedProduct, qtyToAdd);
                        
for (Product p : allProducts) {
    if (p.getName().equals(selectedProduct.getName()) && p.getBrand().equals(selectedProduct.getBrand())) {
        table.setValueAt(p.getStockQuantity() > 0 ? 
            p.getStockQuantity() + " in stock" : "Out of Stock", row, 4);
        break;
    }
}
table.repaint();
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(resultsFrame, 
                            "An error occurred while adding to cart", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(table);
        resultsFrame.add(scrollPane, BorderLayout.CENTER);
        
        JPanel controlPanel = new JPanel();
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> resultsFrame.dispose());
        controlPanel.add(closeButton);
        resultsFrame.add(controlPanel, BorderLayout.SOUTH);
        
        resultsFrame.setVisible(true);
    }
    private void jLabel_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_cartMouseClicked
          System.out.println("Cart label clicked! Cart items: " + cartItems.size() + ", Contents: " + cartItems);
    
    if (cartItems.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Your cart is empty!", "Empty Cart", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    
    try {
        ViewCart viewCart = new ViewCart(this, new Order("CART_" + System.currentTimeMillis(), new ArrayList<>(cartItems)));
        viewCart.setVisible(true);
        viewCart.pack();
        viewCart.setLocationRelativeTo(this);
        System.out.println("ViewCart opened successfully");
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jLabel_cartMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       String selectedOption = (String) jComboBox1.getSelectedItem();
    if ("Order".equals(selectedOption)) {
        if (loggedInCustomer != null) {
            OrderForm orderForm = new OrderForm(loggedInCustomer, this); // Pass this dashboard
            orderForm.setVisible(true);
            orderForm.pack();
            orderForm.setLocationRelativeTo(this);
        } else {
            JOptionPane.showMessageDialog(this, "No user logged in!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        // TODO add your handling code here:
        performSearch();
    }//GEN-LAST:event_jButton_searchActionPerformed

    private void jButton_BacktologinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BacktologinActionPerformed
        // TODO add your handling code here:
        LoginForm database = new LoginForm();
        database.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_BacktologinActionPerformed

    private void showAvailableBrands(String category) {
    List<String> brands = new ArrayList<>();
    for (Product product : allProducts) {
        if (product.getName().equalsIgnoreCase(category) && !brands.contains(product.getBrand())) {
            brands.add(product.getBrand());
        }
    }
    
    StringBuilder brandList = new StringBuilder("<html>Available Brands for " + category + ":<br>");
    for (String brand : brands) {
        brandList.append("- ").append(brand).append("<br>");
    }
    brandList.append("</html>");
    
    JOptionPane.showMessageDialog(this, brandList.toString(), "Available Brands", JOptionPane.INFORMATION_MESSAGE);
}
    
    private void jButton_compressorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_compressorActionPerformed
        // TODO add your handling code here:
       //ProductForm productForm = new ProductForm();
        //productForm.setVisible(true);
        //this.setVisible(false);
        showAvailableBrands("Compressor");
    filteredProducts.clear();
    for (Product product : allProducts) {
        if (product.getName().equalsIgnoreCase("Compressor")) {
            filteredProducts.add(product);
        }
    }
    displaySearchResults();
        
    }//GEN-LAST:event_jButton_compressorActionPerformed

    private void jButton_CondensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CondensorActionPerformed
        // TODO add your handling code here:
        //ProductForm productForm = new ProductForm();
        //productForm.setVisible(true);
        //this.setVisible(false);
        showAvailableBrands("Condenser");
    filteredProducts.clear();
    for (Product product : allProducts) {
        if (product.getName().equalsIgnoreCase("Condenser")) {
            filteredProducts.add(product);
        }
    }
    displaySearchResults();
    }//GEN-LAST:event_jButton_CondensorActionPerformed

    private void jButton_coolingcoilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_coolingcoilActionPerformed
        // TODO add your handling code here:
      //ProductForm productForm = new ProductForm();
        //productForm.setVisible(true);
        //this.setVisible(false);
       showAvailableBrands("Cooling Coil");
    filteredProducts.clear();
    for (Product product : allProducts) {
        if (product.getName().equalsIgnoreCase("Cooling Coil")) {
            filteredProducts.add(product);
        }
    }
    displaySearchResults();
    }//GEN-LAST:event_jButton_coolingcoilActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Customer sampleCustomer = new Customer("test", "user", "test@example.com", "password", "12345");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDashboard(sampleCustomer).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Backtologin;
    private javax.swing.JButton jButton_Condensor;
    private javax.swing.JButton jButton_compressor;
    private javax.swing.JButton jButton_coolingcoil;
    private javax.swing.JButton jButton_search;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel_cart;
    private javax.swing.JLabel jLabel_compressor;
    private javax.swing.JLabel jLabel_condensor;
    private javax.swing.JLabel jLabel_coolingcoil;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_profile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_sidepanel;
    private javax.swing.JTextField jTextField_searchbar;
    // End of variables declaration//GEN-END:variables
}

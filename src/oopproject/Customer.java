package oopproject;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.UUID;

public class Customer extends user {
    private static Random rand = new Random();
    private static ArrayList<Customer> dbcustomers = new ArrayList<>();
    private ArrayList<Item> cart = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();

    public static class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }
    }

    public Customer(String userID, String name, String contact, String email, String password) {
        super(userID, name, contact, email, password, "Customer");
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrder(Order order, String filename) {
    orderHistory.add(order);
    saveOrderToFile(order, filename);
    Inventory inv = new Inventory();
    inv.loadInventoryFromFile("inventory.txt");
    for (Product p : order.getItems()) {
        inv.updateStock(p.getProductID(), -p.getSelectedQuantity());
    }
    inv.saveInventoryToFile("inventory.txt");
    Analytics analytics = new Analytics();
    analytics.loadAnalytics("analytics.txt");
    analytics.updateAnalytics(order.calculateTotal());
    analytics.saveAnalytics("analytics.txt");
}

    private void saveOrderToFile(Order order, String filename) {
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            StringBuilder line = new StringBuilder(order.getOrderId());
            for (Product p : order.getItems()) {
                line.append(",").append(p.getProductID()).append("|").append(p.getName()).append("|")
                    .append(p.getBrand()).append("|").append(p.getPrice()).append("|").append(p.getSelectedQuantity());
            }
            writer.write(line.toString());
            writer.newLine();
            System.out.println("Saved order " + order.getOrderId() + " to " + file.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving order: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadOrdersFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Created new orders file: " + file.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error creating orders file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        orderHistory.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1) {
                    String orderId = parts[0].trim();
                    List<Product> items = new ArrayList<>();
                    for (int i = 1; i < parts.length; i++) {
                        String[] itemParts = parts[i].split("\\|");
                        if (itemParts.length == 5) {
                            try {
                                Product p = new Product(itemParts[1], itemParts[2], Double.parseDouble(itemParts[3]), Integer.parseInt(itemParts[4]));
                                p.setProductID(itemParts[0]); // Set productID from file
                                p.setSelectedQuantity(Integer.parseInt(itemParts[4])); // Use quantity from file
                                items.add(p);
                            } catch (NumberFormatException e) {
                                System.out.println("Error parsing item in line: " + line + " - " + e.getMessage());
                            }
                        }
                    }
                    if (!items.isEmpty()) {
                        Order order = new Order(orderId, items);
                        order.setPaymentMethod("Cash on Delivery"); // Default or parse from file if available
                        orderHistory.add(order);
                    }
                }
            }
            System.out.println("Loaded " + orderHistory.size() + " orders from " + file.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading orders: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<Customer> getDbcustomers() {
        return dbcustomers;
    }

    public void Customerlogin(String inputEmail, String inputPassword) {
        for (Customer c : dbcustomers) {
            if (c.getEmail().equals(inputEmail) && c.getPassword().equals(inputPassword)) {
                JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.userID = c.getUserID();
                this.name = c.getName();
                this.contact = c.getContact();
                this.email = c.getEmail();
                this.password = c.getPassword();
                this.role = c.getRole();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Invalid credentials. Don't have an account? Create Account.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void logout() {
        JOptionPane.showMessageDialog(null, getName() + " logged out.", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }

    public void viewProfile() {
        String profile = "UserID: " + getUserID() + "\n" +
                        "Name: " + getName() + "\n" +
                        "Contact: " + getContact() + "\n" +
                        "Email: " + getEmail() + "\n" +
                        "Role: Customer";
        JOptionPane.showMessageDialog(null, profile, "Profile", JOptionPane.INFORMATION_MESSAGE);
    }

    public void createaccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create New Account:");
        String userID = generateUniqueUserID();
        System.out.println("USERID: " + userID);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Customer newCustomer = new Customer(userID, name, contact, email, password);
        dbcustomers.add(newCustomer);
        this.userID = userID;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.role = "Customer";
        JOptionPane.showMessageDialog(null, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        newCustomer.viewProfile();
        newCustomer.saveToFile("customers.txt");
        System.out.println("Saved customer to customers.txt: " + userID + "," + name + "," + contact + "," + email + "," + password);
    }

    public static String generateUniqueUserID() {
        String userID = null;
        int maxAttempts = 1000;
        int attempts = 0;
        while (attempts <= maxAttempts) {
            String tempID = String.valueOf(100000 + rand.nextInt(900000));
            if (!dbcustomers.stream().anyMatch(c -> c.getUserID().equals(tempID))) {
                userID = tempID;
                break;
            }
            attempts++;
            if (attempts > maxAttempts) {
                throw new RuntimeException("Unable to generate a unique UserID after " + maxAttempts + " attempts. Total customers: " + dbcustomers.size());
            }
        }
        return userID;
    }

    public void saveToFile(String filename) {
        File file = new File(filename);
        try {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                String data = getUserID() + "," + getName() + "," + getContact() + "," + getEmail() + "," + getPassword();
                writer.write(data);
                writer.newLine();
                System.out.println("Saved customer: " + data + " to " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error saving customer to " + filename + ": " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error saving customer to " + filename + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void loadFromFile(String filename) {
        dbcustomers.clear();
        File file = new File(filename);
        if (!file.exists()) {
            try {
                File parentDir = file.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs();
                }
                file.createNewFile();
                System.out.println("Created new file: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error creating file " + filename + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    try {
                        Customer c = new Customer(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim());
                        dbcustomers.add(c);
                    } catch (Exception e) {
                        System.out.println("Error parsing customer: " + e.getMessage());
                    }
                }
            }
            System.out.println("Loaded " + dbcustomers.size() + " customers from " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error loading customers: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error loading customers from " + file.getAbsolutePath() + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addToCart(String name, double price, int quantity) {
        cart.add(new Item(name, price, quantity));
    }

    public void removeFromCart(String name) {
        cart.removeIf(item -> item.getName().equals(name));
    }

    public void updateQuantity(String name, int quantity) {
        for (Item item : cart) {
            if (item.getName().equals(name)) {
                item.quantity = quantity;
                break;
            }
        }
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public double getCartTotal() {
        return cart.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }
}
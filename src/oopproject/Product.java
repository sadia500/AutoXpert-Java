package oopproject;

import java.io.*;
import java.util.*;

public class Product {
    private String productID;
    private String name;
    private String brand;
    private double price;
    private int stockQuantity;
    private int selectedQuantity;
    
    // Constructor with all parameters
    public Product(String name, String brand, double price, int stockQuantity) {
        this.productID = "PROD" + System.currentTimeMillis(); // Auto-generate ID
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.selectedQuantity = 0; // Initialize selected quantity to 0
    }
    
    // Constructor with auto-generated ID
    public Product(String name, String brand, double price) {
        this.productID = "PROD" + System.currentTimeMillis();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = 0;
    }
    
    // Getters
    public String getProductID() {
        return productID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStockQuantity() {
        return stockQuantity;
    }
    
    public int getSelectedQuantity() {
        return selectedQuantity;
    }
    
    // Setter for productID
    public void setProductID(String productID) {
        this.productID = (productID != null && !productID.isEmpty()) ? productID : "PROD" + System.currentTimeMillis();
    }
    
    public void setSelectedQuantity(int selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }
    
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    // Methods
    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }
    
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stockQuantity);
        System.out.println("-------------------------");
    }
    
    // Static methods for file operations
    public static void saveToFile(List<Product> products, String filename) {
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Product p : products) {
                writer.write(p.productID + "," + p.name + "," + p.brand + "," + p.price + "," + p.stockQuantity);
                writer.newLine();
            }
            System.out.println("Products saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving products to " + filename + ": " + e.getMessage());
        }
    }
    
    public static List<Product> loadFromFile(String filename) {
        List<Product> products = new ArrayList<>();
        File file = new File(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.contains("|") ? line.split("\\|") : line.split(",");
                if (parts.length == 5) {
                    try {
                        Product p = new Product(parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Integer.parseInt(parts[4]));
                        p.setProductID(parts[0]); // Set the productID from the file
                        products.add(p);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing line in " + filename + ": " + line + " - " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid line format in " + filename + ": " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading products from " + filename + ": " + e.getMessage());
        }
        return products;
    }
}
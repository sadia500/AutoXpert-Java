package oopproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Supplier {
    private String supplierID;
    private String supplierName;
    private String email;
    private String phone;
    private List<Product> products;

    public Supplier(String supplierID, String supplierName, String email, String phone) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.email = email;
        this.phone = phone;
        this.products = products != null ? products : new ArrayList<>();
    }

    // Getters
    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Static method to load suppliers from file
   public static List<Supplier> loadFromFile(File file) {
        List<Supplier> suppliers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) { // ID, Name, Email, Phone
                    Supplier supplier = new Supplier(data[0], data[1], data[2], data[3]);
                    suppliers.add(supplier);
                }
            }
            System.out.println("Loaded " + suppliers.size() + " suppliers from " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading suppliers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return suppliers;
    }
}
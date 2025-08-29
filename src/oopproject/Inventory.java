package oopproject;

import java.util.*;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(String productID) {
        products.removeIf(p -> p.getProductID().equals(productID));
    }

    public void updateStock(String productID, int quantity) {
        for (Product p : products) {
            if (p.getProductID().equals(productID)) {
                p.updateStock(quantity);
                break;
            }
        }
    }

    public void displayInventory() {
        for (Product p : products) {
            p.displayDetails();
        }
    }

    public void saveInventoryToFile(String filename) {
        Product.saveToFile(products, filename);
    }

    public void loadInventoryFromFile(String filename) {
        products = Product.loadFromFile(filename);
    }

    public List<Product> getProducts() {
        return products;
    }
}
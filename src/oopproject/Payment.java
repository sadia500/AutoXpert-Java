package oopproject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Payment {
    private String paymentID;
    private String method;
    private double amount;
    private List<String> productNames;

    public Payment(String paymentID, String method, double amount, List<String> productNames) {
        this.paymentID = paymentID;
        this.method = method;
        this.amount = amount;
        this.productNames = productNames;
    }
public Payment(String paymentID, String method, double amount) {
        this(paymentID, method, amount, new ArrayList<>());
    }
    public String getPaymentID() { return paymentID; }
    public String getMethod() { return method; }
    public double getAmount() { return amount; }
    public List<String> getProductNames() { return productNames; }

    public void processPayment() {
        System.out.println("Processing payment: " + paymentID + " via " + method);
    }

    public void savePayment(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Payment ID: " + paymentID + ", Method: " + method +
                        ", Amount: " + amount + ", Products: " + productNames + "\n");
        } catch (IOException e) {
            System.err.println("Error saving payment: " + e.getMessage());
        }
    }
}
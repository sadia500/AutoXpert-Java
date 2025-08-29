package oopproject;
import java.io.BufferedWriter;
import java.io.File;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction {
    
    private String transactionID;
    private String paymentMethod;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String transactionID, String paymentMethod, double amount, LocalDateTime dateTime) {
        this.transactionID = transactionID;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.dateTime = dateTime;
    }
    public Transaction(String transactionID, double amount, String paymentMethod) {
        this(transactionID, amount, paymentMethod, LocalDateTime.now());
    }

    private Transaction(String transactionID, double amount, String paymentMethod, LocalDateTime now) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: $" + amount);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Date/Time: " + dateTime);
    }
    

    public String getTransactionID() { return transactionID; }
    public String getPaymentMethod() { return paymentMethod; }
    public double getAmount() { return amount; }
    public LocalDateTime getDateTime() { return dateTime; }

    
    public void saveTransaction(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Transaction ID: " + transactionID + ", Method: " + paymentMethod +
                        ", Amount: " + amount + ", DateTime: " + dateTime + "\n");
        } catch (IOException e) {
            System.err.println("Error saving transaction: " + e.getMessage());
        }
    }
}

package oopproject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Invoice {
    private String invoiceId;
    private String customerName;
    private List<String> items;
    private double totalAmount;
    private LocalDateTime dateTime;

    public Invoice(String customerName, List<String> items, double totalAmount) {
        this.invoiceId = "INV" + System.currentTimeMillis();
        this.customerName = customerName;
        this.items = items;
        this.totalAmount = totalAmount;
        this.dateTime = LocalDateTime.now();
    }

    public String getInvoiceId() { return invoiceId; }
    public String getCustomerName() { return customerName; }
    public List<String> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
     public void setTotalAmount(double totalAmount) { this.totalAmount = this.totalAmount; }
    public LocalDateTime getDateTime() { return dateTime; }

    public void saveInvoice(String filename, Order order) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            writer.write("Invoice ID: " + invoiceId + "\n");
            writer.write("Customer: " + customerName + "\n");
            writer.write("Date/Time: " + dateTime.format(formatter) + "\n");
            writer.write("Items:\n");
            for (String item : items) {
                writer.write("- " + item + "\n");
            }
            writer.write("Total: $" + String.format("%.2f", totalAmount) + "\n");
            writer.write("Payment Method: " + (order.getPaymentMethod() != null ? order.getPaymentMethod() : "Not Selected") + "\n");
            writer.write("-------------------------\n");
        } catch (IOException e) {
            System.err.println("Error saving invoice: " + e.getMessage());
        }
    }
}
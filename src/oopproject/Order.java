package oopproject;
import java.util.List;
public class Order {
    private String orderId;
    private List<Product> items;
    private String paymentMethod;
    private Invoice invoice;
private void updateInvoice() {
        List<String> itemDescriptions = items.stream()
            .map(item -> String.format("%s (x%d) - $%.2f", item.getName(), item.getStockQuantity(), item.getPrice()))
            .toList();
        double total = calculateTotal();
        this.invoice = new Invoice("John Doe", itemDescriptions, total);
    }
    public Order(String orderId, List<Product> items) {
        this.orderId = orderId;
        this.items = items;
        List<String> itemDescriptions = items.stream()
            .map(item -> String.format("%s (x%d) - $%.2f", item.getName(), item.getStockQuantity(), item.getPrice()))
            .toList();
        double total = items.stream().mapToDouble(item -> item.getPrice() * item.getStockQuantity()).sum();
        this.invoice = new Invoice("John Doe", itemDescriptions, total);
    }
 public void confirmOrder() {
        updateInvoice(); // [CHANGE] Ensure invoice is updated
    }

    // [CHANGE] Added method to remove item by name
    public boolean removeItemByName(String name) {
        boolean removed = items.removeIf(item -> item.getName().equals(name));
        if (removed) {
            updateInvoice();
        }
        return removed;
    }

    // [CHANGE] Added method to calculate total
    public double calculateTotal() {
        double subtotal = 0.0;
        for (Product product : items) {
            subtotal += product.getPrice() * product.getSelectedQuantity();
        }
        double serviceFee = 2.0;
        double deliveryFee = 5.0;
        double tax = subtotal * 0.05;
        double total = subtotal + tax + serviceFee + deliveryFee;
        if (invoice != null) {
            invoice.setTotalAmount(total); // Sync with Invoice
        }
        return total;
    }
    public String getOrderId() { return orderId; }
    public List<Product> getItems() { return items; }
    public String getPaymentMethod() { return paymentMethod; }
    public Invoice getInvoice() { return invoice; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

   

}
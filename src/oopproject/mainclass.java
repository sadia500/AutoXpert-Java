package oopproject;

import java.util.*;
import java.time.LocalDateTime;


public class mainclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Load data from files at startup
        Customer.loadFromFile("customers.txt");
        Inventory inventory = new Inventory();
        inventory.loadInventoryFromFile("products.txt");
        Analytics analytics = new Analytics();
        analytics.loadAnalytics("analytics.txt");

        Admin admin = new Admin("ADMIN001", "Owner", "000-ADMIN", "kashifkh", "ADMIN123", "Admin");
        Customer customer = new Customer("", "", "", "", ""); // Placeholder customer

        // Add default products if inventory is empty
        if (inventory.getProducts().isEmpty()) {
            inventory.addProduct(new Product("Compressor", "Denso", 12000.09, 5));
            inventory.addProduct(new Product("Condenser", "Sanden", 8000, 3));
        }

        while (true) {
            System.out.println("\n===== WELCOME TO CAR AC PARTS SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Registration");
            System.out.println("3. Customer Login");
            System.out.println("4. Update Profile");
            System.out.println("5. Place Order");
            System.out.println("6. View Inventory");
            System.out.println("7. View Analytics");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter your Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    admin.adminLogin(email, password);
                    break;

                case 2:
                    customer = new Customer("", "", "", "", ""); // Reset customer for registration
                    customer.createaccount();
                    break;

                case 3:
                    System.out.print("Enter email: ");
                    String inputEmail = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String inputPassword = scanner.nextLine();
                    customer = new Customer("", "", "", inputEmail, inputPassword); // Temporary customer for login
                    customer.Customerlogin(inputEmail, inputPassword);
                    break;

                case 4:
                    System.out.println("UPDATE PROFILE:");
                    System.out.print("Enter new Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter new contact: ");
                    String newContact = scanner.nextLine();
                    customer.updateProfile(newContact, newEmail, newPassword);
                    customer.saveToFile("customers.txt");
                    break;

                case 5:
                    inventory.displayInventory();
                    System.out.print("Enter product ID to purchase: ");
                    String pid = scanner.nextLine();

                    List<Product> selectedItems = new ArrayList<>();
                    for (Product p : inventory.getProducts()) {
                        if (p.getProductID().equals(pid)) {
                            selectedItems.add(p);
                            break;
                        }
                    }

                    if (selectedItems.isEmpty()) {
                        System.out.println("Product not found!");
                        break;
                    }

                    Order order = new Order("ORD" + System.currentTimeMillis(), selectedItems);
                    order.confirmOrder(); // **Changed: Removed separate invoice creation since confirmOrder handles it**
                    Invoice invoice = order.getInvoice();
                    // invoice.setTotalAmount(order.calculateTotal()); // **Removed: Redundant, handled in confirmOrder**

                    Payment payment = new Payment("PAY" + System.currentTimeMillis(), "Card", order.calculateTotal());
                    payment.processPayment();
                    payment.savePayment("payments.txt");

                    Transaction transaction = new Transaction("TXN" + System.currentTimeMillis(), order.calculateTotal(), "Card");
                    transaction.displayTransaction();
                    transaction.saveTransaction("transactions.txt");

                    analytics.updateAnalytics(order.calculateTotal());
                    System.out.println("Order placed successfully!");
                    break;

                case 6:
                    inventory.displayInventory();
                    break;

                case 7:
                    analytics.displayAnalytics();
                    break;

                case 8:
                    inventory.saveInventoryToFile("products.txt");
                    analytics.saveAnalytics("analytics.txt");
                    System.out.println("All data saved. Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
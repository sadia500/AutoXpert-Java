package oopproject;

import java.io.*;

public class Analytics {
    private int totalOrders;
    private double totalRevenue;

    public Analytics() {
        this.totalOrders = 0;
        this.totalRevenue = 0.0;
    }

    public int getTotalOrders() { return totalOrders; }
    public double getTotalRevenue() { return totalRevenue; }

    public void updateAnalytics(double orderAmount) {
        totalOrders++;
        totalRevenue += orderAmount;
        saveAnalytics("analytics.txt");
    }

    public void saveAnalytics(String filename) {
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("TotalOrders=" + totalOrders + "\n");
            writer.write("TotalRevenue=" + totalRevenue);
            System.out.println("Analytics saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Save error: " + e.getMessage());
        }
    }

    public void loadAnalytics(String filename) {
        File file = new File(filename);
        totalOrders = 0;
        totalRevenue = 0.0;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Create error: " + e.getMessage());
            }
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("TotalOrders=")) totalOrders = Integer.parseInt(line.replace("TotalOrders=", ""));
                else if (line.startsWith("TotalRevenue=")) totalRevenue = Double.parseDouble(line.replace("TotalRevenue=", ""));
            }
            System.out.println("Loaded: Orders=" + totalOrders + ", Revenue=" + totalRevenue);
        } catch (Exception e) {
            System.err.println("Load error: " + e.getMessage());
        }
    }

    void displayAnalytics() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
package org.example.sheet;
import java.io.*;
import java.util.Scanner;

public class Practice {
    private String productName;
    private int quantity;
    private static int totalItems = 0;

    public Practice(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
        totalItems += quantity;
    }

    public void displayInfo() {
        System.out.println("Product: " + productName + ", Quantity: " + quantity);
    }

    public static void showTotalItems() {
        System.out.println("Total items bought: " + totalItems);
    }

    // Static method to write purchases to a file
    public static void writeToFile(String[] items) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("purchases.txt", true))) {
            for (String item : items) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("✔ Purchase details saved to purchases.txt");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }
}


package org.example.sheet;
import java.util.Scanner;

public class Main extends Practice {

    // Constructor using super
    public Main(String productName, int quantity) {
        super(productName, quantity);
    }

    // Polymorphic override
    @Override
    public void displayInfo() {
        System.out.println("[Main Class] Product: " + productName + ", Quantity: " + quantity);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Practice[] purchases = new Practice[3]; // Array of objects

        for (int i = 0; i < purchases.length; i++) {
            try {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();

                System.out.print("Enter quantity: ");
                int qty = Integer.parseInt(scanner.nextLine()); // Might throw NumberFormatException

                // Using polymorphism
                purchases[i] = new Main(name, qty);

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid quantity. Please enter a number.");
                i--; // Retry the same index
            }
        }

        // Loop and method call
        System.out.println("\n--- Purchase Summary ---");
        for (Practice p : purchases) {
            p.displayInfo(); // Polymorphic call
        }

        // Static method call
        Practice.showTotalItems();

        // File Handling
        String[] purchaseData = new String[purchases.length];
        for (int i = 0; i < purchases.length; i++) {
            purchaseData[i] = purchases[i].productName + "," + purchases[i].quantity;
        }
        Practice.writeToFile(purchaseData);
    }
}

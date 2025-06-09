package org.example.filehandling;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// r, w,
public class FileHandling {

    public static void main(String[] args) {
        String filePath = "D:\\DEV\\trisha-project\\tisu.txt";
//        "D:/DEV/trisha-project/tisu.txt";

        // Write to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("We are writing file handling.......");
            System.out.println("Data written successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Read from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}

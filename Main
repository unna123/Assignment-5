package assignment5;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
     
        String filePath = "sales_data.txt";  
        
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        try {
            
            double[][] salesData = TwoDimRaggedArrayUtility.readFile(filePath);
            System.out.println("Sales Data loaded from file:");
            printSalesData(salesData);

            
            double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData);
            System.out.println("\nHoliday Bonuses:");
            printBonuses(bonuses);

            double totalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);
            System.out.println("\nTotal Holiday Bonus for the District: $" + totalBonus);

    
            String outputPath = "sales_data_output.txt";
            TwoDimRaggedArrayUtility.writeToFile(salesData, outputPath);
            System.out.println("\nSales data written to: " + outputPath);

        } catch (FileNotFoundException e) {
            System.err.println("Error: The file was not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: There was an issue writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to print the sales data (2D ragged array)
    private static void printSalesData(double[][] salesData) {
        for (int i = 0; i < salesData.length; i++) {
            System.out.print("Store " + (i + 1) + ": ");
            for (int j = 0; j < salesData[i].length; j++) {
                System.out.print(salesData[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to print the calculated holiday bonuses
    private static void printBonuses(double[] bonuses) {
        for (int i = 0; i < bonuses.length; i++) {
            System.out.println("Store " + (i + 1) + " Holiday Bonus: $" + bonuses[i]);
        }
    }
}

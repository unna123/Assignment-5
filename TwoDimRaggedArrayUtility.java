package assignment5;

import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {
    
    // Reads a file and returns a two-dimensional ragged array of doubles
    public static double[][] readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<List<Double>> data = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\\s+");
            List<Double> row = new ArrayList<>();
            for (String value : line) {
                row.add(Double.parseDouble(value));
            }
            data.add(row);
        }
        
        double[][] array = new double[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            List<Double> row = data.get(i);
            array[i] = new double[row.size()];
            for (int j = 0; j < row.size(); j++) {
                array[i][j] = row.get(j);
            }
        }
        
        return array;
    }

    public static void writeToFile(double[][] array, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        
        for (double[] row : array) {
            StringBuilder sb = new StringBuilder();
            for (double value : row) {
                sb.append(value).append(" ");
            }
            writer.write(sb.toString().trim());
            writer.newLine();
        }
        
        writer.close();
    }

    // Calculates the total of all elements
    public static double getTotal(double[][] array) {
        double total = 0;
        for (double[] row : array) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] array) {
        double total = getTotal(array);
        int count = 0;
        for (double[] row : array) {
            count += row.length;
        }
        return count == 0 ? 0 : total / count;
    }

    // Calculates the total ofa  row
    public static double getRowTotal(double[][] array, int rowIndex) {
        double total = 0;
        for (double value : array[rowIndex]) {
            total += value;
        }
        return total;
    }

    // Calculates the total of a column
    public static double getColumnTotal(double[][] array, int colIndex) {
        double total = 0;
        for (double[] row : array) {
            if (colIndex < row.length) {
                total += row[colIndex];
            }
        }
        return total;
    }

    // Finds the highest value in a row
    public static double getHighestInRow(double[][] array, int rowIndex) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double value : array[rowIndex]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    // Finds the index of the highest value 
    public static int getHighestInRowIndex(double[][] array, int rowIndex) {
        int highestIndex = -1;
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] > highest) {
                highest = array[rowIndex][i];
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    // Finds the lowest value
    public static double getLowestInRow(double[][] array, int rowIndex) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double value : array[rowIndex]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }

    // Finds the index of the lowest value 
    public static int getLowestInRowIndex(double[][] array, int rowIndex) {
        int lowestIndex = -1;
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] < lowest) {
                lowest = array[rowIndex][i];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    // Finds the highest value
    public static double getHighestInColumn(double[][] array, int colIndex) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : array) {
            if (colIndex < row.length) {
                if (row[colIndex] > highest) {
                    highest = row[colIndex];
                }
            }
        }
        return highest;
    }

    public static int getHighestInColumnIndex(double[][] array, int colIndex) {
        int highestIndex = -1;
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < array.length; i++) {
            if (colIndex < array[i].length && array[i][colIndex] > highest) {
                highest = array[i][colIndex];
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    public static double getLowestInColumn(double[][] array, int colIndex) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : array) {
            if (colIndex < row.length) {
                if (row[colIndex] < lowest) {
                    lowest = row[colIndex];
                }
            }
        }
        return lowest;
    }

    public static int getLowestInColumnIndex(double[][] array, int colIndex) {
        int lowestIndex = -1;
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < array.length; i++) {
            if (colIndex < array[i].length && array[i][colIndex] < lowest) {
                lowest = array[i][colIndex];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    // Finds the highest value in the entire array
    public static double getHighestInArray(double[][] array) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : array) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    public static double getLowestInArray(double[][] array) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : array) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }
}

package assignment5;

public class HolidayBonus {
    
    
    private static final double HIGHEST_SALES_BONUS = 5000.0;
    private static final double LOWEST_SALES_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    // Method to calculate the holiday bonus for all stores based on sales data
    public static double[] calculateHolidayBonus(double[][] salesData) {
        double[] bonuses = new double[salesData.length];

        //max number
        int maxColumns = 0;
        for (double[] row : salesData) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }

        // Loop through each column
        for (int col = 0; col < maxColumns; col++) {
            int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(salesData, col);
            int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(salesData, col);

            for (int row = 0; row < salesData.length; row++) {
                
                if (col >= salesData[row].length || salesData[row][col] <= 0) {
                    continue;
                }

                if (row == highestIndex) {
                    bonuses[row] += HIGHEST_SALES_BONUS;
                } else if (row == lowestIndex) {
                    bonuses[row] += LOWEST_SALES_BONUS;
                } else {
                    bonuses[row] += OTHER_BONUS;
                }
            }
        }

        return bonuses;
    }


    // Method to calculate the total holiday bonus for all stores
    public static double calculateTotalHolidayBonus(double[][] salesData) {
        double totalBonus = 0.0;
        double[] bonuses = calculateHolidayBonus(salesData);
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }
}

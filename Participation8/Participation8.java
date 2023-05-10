
/**
 * CMIS 242
 * Maria Caballero Participation
 * Modifications of Jason's Fetch Program
 * Date: 05/03/2023
 */
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Participation8 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0"); // Decimal Format for completion percentage
        String statArray[][] = new String[17][4]; // Instantiating 2D array with the number of NFL weeks and number of
                                                  // stats tracked
        Scanner fileScanner; // Scanner to later read from the text file in "myFile"
        /**
         * Maria Caballero: declaring a PrintWriter object to print the results into a
         * new file
         */
        PrintWriter statsResult;
        try { // using a try block to catch an exception if no file is found. Otherwise, binds
            fileScanner = new Scanner(new File(
                    "C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\Participation8Files\\stats.txt"));
            /**
             * Creating a .txt file into the same directory to print the values but instead
             * of printing them into the console, I will print them into a file in the form
             * of a table.
             */
            statsResult = new PrintWriter(
                    "C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\Participation8Files\\statsResult.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            return;
        }

        /**
         * Maria Caballero: Storing the titles of the table into the new file
         */
        statsResult.println("\nWeek\tYards\t\sPCT\tTDs\tINTs");
        statsResult.println("+----+-----+-----+-----+-----+");

        // Populating the entire array using nested for loops and multiple scanners
        String line; // holds the value for a single line of myFile
        Scanner lineScanner; // scanner to take individual values from each line using next() method
        for (int row = 0; row < 17; row++) {
            line = fileScanner.nextLine();

            lineScanner = new Scanner(line);
            for (int column = 0; column < 4; column++) {
                statArray[row][column] = lineScanner.next();
            }
            lineScanner.close(); // closing scanner
        }

        // creating table to display the 2D array of statistics using nested for-loops
        System.out.println("\n Week\t Yards\t PCT\t TDs\t INTs");
        System.out.println("+-------+-------+-------+-------+-------+");
        int week = 1;
        for (int row = 0; row < 17; row++) {
            System.out.print("|" + week + "\t|");
            statsResult.print(week + "\t");
            for (int column = 0; column < 4; column++) {
                System.out.print(statArray[row][column] + "\t");
                /**
                 * Maria Caballero: printing the data from one file into the another one instead
                 * of the printing it to the console.
                 */
                statsResult.print("\s" + statArray[row][column] + "\t");
            }
            System.out.print("\n");
            statsResult.println();
            week++;
        }

        // preparing variables to get total statistics for the bottom of the table
        int totalYards = 0;
        double completionPercentage = 0.0;
        int totalTDs = 0;
        int totalINTs = 0;

        // preparing variables to use in try-catch blocks; must parse the string values
        // in the array to integers/doubles
        int intParsedValue = 0;
        double doubleParsedValue = 0.0;

        // lots of chunky repeated code to add up each collumn of the array
        for (int i = 0; i < 17; i++) {
            try {
                intParsedValue = Integer.parseInt(statArray[i][0]);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number of yards");
            }
            totalYards = totalYards + intParsedValue;
        }
        for (int i = 0; i < 17; i++) {
            try {
                doubleParsedValue = Double.parseDouble(statArray[i][1]);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number of yards");
            }
            completionPercentage = completionPercentage + doubleParsedValue;
        }
        completionPercentage = completionPercentage / 17;
        for (int i = 0; i < 17; i++) {
            try {
                intParsedValue = Integer.parseInt(statArray[i][2]);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number of yards");
            }
            totalTDs = totalTDs + intParsedValue;
        }
        for (int i = 0; i < 17; i++) {
            try {
                intParsedValue = Integer.parseInt(statArray[i][3]);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number of yards");
            }
            totalINTs = totalINTs + intParsedValue;
        }
        /*
         * Maria Caballero: printing the last string into the new file before flushing
         * and closing the file.
         */
        statsResult.println("+-----+------+-----+-----+-----+");
        statsResult
                .println("total\t\s" + totalYards + "\t\s\s\s" + df.format(completionPercentage) + "\s\s\s" + totalTDs
                        + "\s\s\s\s"
                        + totalINTs + "\t");
        // Maria Caballero - Making sure to flush data into new file
        statsResult.flush();
        // Maria Caballero - closing file
        statsResult.close();

        // printing the bottom section of the table, to include totals/average
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|total\t|" + totalYards + "\t|" + df.format(completionPercentage) + "\t|" + totalTDs + "\t|"
                + totalINTs + "\t|");
        fileScanner.close(); // closing scanner
    }

}

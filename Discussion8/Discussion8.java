
/**
 * CMIS 242 - Discussion 8
 * Student Name: Maria Caballero
 * Date: 04/18/2021
 * Program Summary: 
 *          This program reads data from a file and stores it in an ArrayList.
 *          From the ArrayList numbers calculates a final grade for each student 
 *          and stores it in an array called finalGrade. Then stores the full 
 *          names of the students into another array called studentFullName.
 *          Finally, it stores the grades and names in a 2D array called
 *          gradesListArray and prints the results to a file called ResultsList.txt
 *          in the form of a table.
 *          
 */
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Discussion8 {
    public static void main(String[] args) {
        Scanner data; // Scanner object = read data from file
        PrintWriter result; // PrintWriter object = write data to file
        /**
         * gradesListArray = 2D array
         * -6 rows = Students Names (5 students + 1 row for the title)
         * -6 columns = 5 grades (assignments 1,2,3; Final Project and Final grade (this
         * will be calculated) + 1 column for the title)
         */

        String[][] gradesListArray = new String[6][6]; // 2D array = stores the students with their corresponding grades
        ArrayList<Double> gradesList = new ArrayList<Double>(); // ArrayList gradesList = store grades for students
        ArrayList<String> studentsList = new ArrayList<String>(); // ArrayList studentsList = store student names
        double[] finalGrade = new double[5]; // Final grade is calculated for each student and stored in this array
        String[] studentFullName = new String[5]; // This array will store the full name of the students
        DecimalFormat df = new DecimalFormat("0.00"); // DecimalFormat object = format the final grade to 2 decimal
                                                      // places

        // Try and catch block to catch any errors
        try {
            data = new Scanner(new File(
                    "C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\Discussion8Files\\GradesList.txt"));
            result = new PrintWriter(new File(
                    "C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\Discussion8Files\\ResultsList.txt"));

            /**
             * Store the titles in the first row of the 2D array
             * [row 0][column 0] = "Student Name"
             * [row 0][column 1] = "Assignment 1"
             * [row 0][column 2] = "Assignment 2"
             * [row 0][column 3] = "Assignment 3"
             * [row 0][column 4] = "Final Project"
             * [row 0][column 6] = "Final Grade"
             */
            gradesListArray[0][0] = "Student Name\t";
            gradesListArray[0][1] = "\tAssignment 1\t\t\s";
            gradesListArray[0][2] = "Assignment 2\t\t\s";
            gradesListArray[0][3] = "Assignment 3\t\t\s";
            gradesListArray[0][4] = "Final Project\t\t\s";
            gradesListArray[0][5] = "Final Grade";

            /**
             * While loop is used to store the data from the file into the ArrayLists
             * gradesList = store the grades which is of type Double
             * studentsList = store the student names which is of type String
             */
            while (data.hasNext()) {
                // if data is a double, store it in the gradesList ArrayList
                if (data.hasNextDouble()) {
                    gradesList.add(data.nextDouble()); // stores the grades
                } // else if data is a string store it in the studentsList ArrayList
                else {
                    studentsList.add(data.next()); // stores the student names
                } // end of if-else statements
            } // end of while loop

            /**
             * Calculating final grade for each student by getting the grades from the
             * gradesList ArrayList and storing them in the finalGrade array.
             * I will be using 4 counters to get the first 4 grades and divide them by 4
             * to get the first final grade and so on for next consecutive grades.
             * The counters will be incremented by 4 to get the next 4 grades for next
             * student.
             */
            int counterZero = 0; // get 0, then 4, then 8, then 12, then 16
            int counterOne = 1; // get 1, then 5, then 9, then 13, then 17
            int counterTwo = 2; // get 2, then 6, then 10, then 14, then 18
            int counterThree = 3; // get 3, then 7, then 11, then 15, then 19
            for (int i = 0; i < 5; i++) {
                finalGrade[i] = (gradesList.get(counterZero) + gradesList.get(counterOne) + gradesList.get(counterTwo)
                        + gradesList.get(counterThree)) / 4;
                counterZero += 4;
                counterOne += 4;
                counterTwo += 4;
                counterThree += 4;
                // formatting the final grade to 2 decimal places
                finalGrade[i] = Double.parseDouble(df.format(finalGrade[i]));
            } // end of for loop

            /**
             * I will be storing the name of the students in a new array of strings
             * and use the studentCounter to get the names from the studentsList ArrayList
             * studentFullName[0] = Student Name 1
             * studentFullName[1] = Student Name 2
             * studentFullName[2] = Student Name 3
             * studentFullName[3] = Student Name 4
             * studentFullName[4] = Student Name 5
             */
            int studentCounter = 0;
            for (int i = 0; i < 5; i++) {
                // storing the full name of the students in the array
                studentFullName[i] = studentsList.get(studentCounter++) + " " + studentsList.get(studentCounter++);
            } // end of for loop

            /**
             * Next I will be storing the grades and names in the 2D array
             * I will use counter2 to store the grades each student received for each
             * specific assignment
             * [row 1][column 1,2,3,4,5] = Student 1: Assignment 1, Assignment2,
             * Assignment3, Final Project, Final Grade
             * [row 2][column 1,2,3,4,5] = Student 2: Assignment 1, Assignment2,
             * Assignment3, Final Project, Final Grade
             * [row 3][column 1,2,3,4,5] = Student 3: Assignment 1, Assignment2,
             * Assignment3, Final Project, Final Grade
             * [row 4][column 1,2,3,4,5] = Student 4: Assignment 1, Assignment2,
             * Assignment3, Final Project, Final Grade
             * [row 5][column 1,2,3,4,5] = Student 5: Assignment 1, Assignment2,
             * Assignment3, Final Project, Final Grade
             */
            int counter2 = 0;
            for (int i = 1; i < 6; i++) { // rows
                // Storing student Names
                gradesListArray[i][0] = String.format("%-15s", studentFullName[i - 1]);
                for (int j = 1; j < 6; j++) { // columns
                    if (j == 5) {
                        // Storing the final grade in the last column for each student
                        gradesListArray[i][j] = String.format("%15.2f", finalGrade[i - 1]) + "\n"; // column
                    } else {
                        // stores the grades in the first 4 columns for each student
                        gradesListArray[i][j] = String.format("%15.2f", gradesList.get(counter2++)) + "\t\t";
                    } // end of if-else statement
                } // end of inner for loop
            } // end of outer for loop

            // Print the data to the file
            for (int i = 0; i < 6; i++) { // rows
                for (int j = 0; j < 6; j++) { // columns
                    result.print(gradesListArray[i][j]);
                } // end of inner for loop
                result.println();
            } // end of outer for loop

            // Make sure data is actually sent to the file
            result.flush();

            // Check if there is any errors, else print Done
            if (result.checkError()) {
                System.out.println("Something went wrong.");
            } else {
                System.out.println("Done.");
            }
            // Close the files
            data.close();
            result.close();

            // catch if the file is not found
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return; // exit the program

            // catch any other exceptions
        } catch (Exception e) {
            System.out.println("Error opening the file.");
            System.out.println(e.getMessage());
            return; // exit the program

            // finally block to make sure data printed to the file is correct by printing it
            // to the console
        } finally {
            for (int i = 0; i < 6; i++) { // rows
                for (int j = 0; j < 6; j++) { // columns
                    System.out.print(gradesListArray[i][j]);
                } // end of inner for loop
                System.out.println();
            } // end of outer for loop
        } // end of finally block
    }// end of main method
}// end of class

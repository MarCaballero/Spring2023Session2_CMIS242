/*
 * CMIS 242: Discussion 6
 * Student Name: Maria Caballero
 * Date: 04/18/2023
 * Program Summary:
 *          This program is a school database system that allows users to enter their name, age, and school or subject depending on the
 *          user input (S or T). The program then displays the user's name, age, and school or subject according to the instance class. 
 *          Additionally, the program displays a random number that accounts for a unique ID for either students or teachers. 
 *          It gives also the option to exit the program when the user is done. The program is a representation of what dynamic binding is.
 */


import java.util.*;
public class main {
    public static void main(String[] args) {
        //creating scanner objects
        Scanner stringInput = new Scanner(System.in);
        Scanner integerInput = new Scanner(System.in);
        Scanner wholeStringInput = new Scanner(System.in);

        //Displaying Menu
        System.out.println("\t\tWelcome to the School Database System");
        System.out.print("Enter if you are a Student (S) or Teacher (T), else enter exit (E): ");
        //User Input
        String type = stringInput.next();
        //converting user input to uppercase in case they entered lowercase
        type = type.toUpperCase();

        //while loop to keep program running until user enters exit
        while(type.equals("S") || type.equals("T")){
            //User Input
            System.out.print("Enter your name: ");
            String name = stringInput.next();
            System.out.print("Enter your age: ");
            int age = integerInput.nextInt();

            //Creating object depending on user input
            if(type.equals("S")){
                System.out.print("Enter the school you attend: ");
                String school = wholeStringInput.nextLine();
                Student student = new Student(name, age, school);
                /**
                 * Dynamic binding happening here
                 */
                student.activity();
                //new line to separate outputs
                System.out.println();
            }
            if(type.equals("T")){
                System.out.print("Enter the subject you teach: ");
                String subject = stringInput.next();
                Teacher teacher = new Teacher(name, age, subject);
                /**
                 * Dynamic binding happening here
                 */
                teacher.activity();
                /**
                 * This method is unique to the Teacher class
                 */
                teacher.subject();
                //new line to separate outputs
                System.out.println();
            }
            //Displaying Menu again
            System.out.print("Enter if you are a Student (S) or Teacher (T), else enter exit (E): ");
            type = stringInput.next();
            type.toUpperCase();
        }
        //closing scanner objects
        stringInput.close();
        integerInput.close();
        wholeStringInput.close();

        //gratefully exiting program
        System.out.println("Thank you for using the School Database System. Goodbye!");

        }
}

/**
 * CMIS 242: Discussion 5
 * Student Name: Maria Caballero
 * Date: 04/14/2023
 * Program Summary: 
 *       This program is a reservation system for a restaurant. The user will be able to choose between two different restaurants,
 *       and will be able to make a table reservation for the restaurant of his/her choice.
 *       Finally, The user will be able to make as many reservations as he/she wants until he/she decides to exit the program.
 *         
 */

import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        //creating Scanner object
        Scanner input = new Scanner(System.in);
        System.out.println("----------Welcome to the reservation system!----------");
        System.out.println("\tMENU");
        System.out.println("1. Italian");
        System.out.println("2. Mexican");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = 0;
        /**
         * This try-catch block will catch any invalid input from the user.
         * If the user enters a number that is not between 1 and 3, the program will ask the user to enter a valid input.
         * If the user enters letters instead of numbers, the program will throw an exception and exit the program.
         */
        try{
            choice = input.nextInt();
            if(choice < 1 || choice > 3){
                System.out.print("Sorry, you have entered an invalid input. Please try again: ");
                choice = input.nextInt();
            }
        }catch(InputMismatchException e){
            throw new InputMismatchException("Sorry, you have entered letters instead of numbers. Please try again.");
        }
        /**
         * This while loop will keep running until the user enters 3 to exit the program.
         */
        while(choice != 3){
            //This variable will keep track of the number of reservations the user wants to make
            int numReservations = 0;
            //If the user chose is 1 then reservation will go to the Italian Restaurant
            if(choice == 1){
                System.out.print("How many tables would you like to reserve? ");
                /**
                 * This try-catch block will catch any invalid input from the user.
                 * If the user enters a negative number, the program will ask the user to enter a valid input.
                 * If the user enters letters instead of numbers, the program will throw an exception and exit the program.
                 */
                try{
                    numReservations = input.nextInt();
                    if(numReservations < 0){
                        System.out.print("Sorry, you have entered a negative number. Please try again: ");
                        numReservations = input.nextInt();
                    }
                }catch(Exception e){
                    throw new Exception("Sorry, you have entered letters instead of numbers. Please try again: ");
                }
                //Creating an object of the ItalianRestaurant class
                ItalianRestaurant italian = new ItalianRestaurant();
                italian.makeReservation(numReservations);   
                italian.displayReservations(numReservations);
                System.out.println();
                }

            //If the user chose is 2 then reservation will go to the Mexican Restaurant
            else if(choice == 2){
                System.out.print("How many tables would you like to reserve? ");
                /**
                 * This try-catch block will catch any invalid input from the user.
                 * If the user enters a negative number, the program will ask the user to enter a valid input.
                 * If the user enters letters instead of numbers, the program will throw an exception and exit the program.
                 */
                try{
                    numReservations = input.nextInt();
                    if(numReservations < 0){
                        System.out.print("Sorry, you have entered a negative number. Please try again: ");
                        numReservations = input.nextInt();
                    }
                }catch(Exception e){
                    throw new Exception("Sorry, you have entered letters instead of numbers. Please try again: ");
                }
                //Creating an object of the MexicanRestaurant class
                MexicanRestaurant mexican = new MexicanRestaurant();
                mexican.makeReservation(numReservations);
                mexican.displayReservations(numReservations);
                System.out.println();
            }
            //At the end the user is ask if he wants to see the reservation menu again
            System.out.println("Would you like to see the menu again (true, false)? ");
            boolean menu;
            /**
             * This try-catch block will catch any invalid input from the user.
             * If the user enters any other input than true or false, the program will throw an exception and exit the program.
             */
            try{
                menu = input.nextBoolean();
            }catch(InputMismatchException e){
                throw new InputMismatchException("Invalid input. Please enter true or false.");
            }
            //if is false then the program will end
            if(menu == false){
                break;
            }
            //if the user enters true then the menu will be displayed again
                //If the user just wanted to look at the menu but not make another reservation then the user has the option to exit
            System.out.println("\tMENU");
            System.out.println("1. Italian");
            System.out.println("2. Mexican");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();    
        }
        //Goodbye message
        System.out.println();
        System.out.println("Thank you for using the reservation system. See you next time!");
        input.close();
    }
}

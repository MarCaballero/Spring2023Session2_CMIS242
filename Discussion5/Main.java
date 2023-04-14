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
    public static void main(String[] args) {
        //creating Scanner object
        Scanner input = new Scanner(System.in);
        System.out.println("----------Welcome to the reservation system!----------");
        System.out.println("\tMENU");
        System.out.println("1. Italian");
        System.out.println("2. Mexican");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        int numReservations = 0;
        while(choice != 3){
            //If the user chose is 1 then reservation will go to the Italian Restaurant
            if(choice == 1){
                ItalianRestaurant italian = new ItalianRestaurant();
                System.out.print("How many tables would you like to reserve? ");
                numReservations = input.nextInt();
                italian.makeReservation(numReservations);
                italian.displayReservations(numReservations);
                System.out.println();
            }
            //If the user chose is 2 then reservation will go to the Mexican Restaurant
            else if(choice == 2){
                MexicanRestaurant mexican = new MexicanRestaurant();
                System.out.println("How many tables would you like to reserve? ");
                numReservations = input.nextInt();
                mexican.makeReservation(numReservations);
                mexican.displayReservations(numReservations);
                System.out.println();
            }

            //At the end the user is ask if he wants to see the reservation menu again
            System.out.println("Would you like to see the menu again (true, false)? ");
            boolean menu = input.nextBoolean();
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

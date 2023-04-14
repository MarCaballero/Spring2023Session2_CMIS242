//Author: Maria Caballero
//Date: 04/07/2023
/*Program Summary: This program will create a GUI that will allow the user to pick between two types of snacks: 
                   Fruit Snack and Salty Snack. If the user don't want to pick any snack he can click the "Exit" button.
                   The user will be able to pick the size of the snack and the type: Is citrus? (for Fruit Snack) and
                   Is nut? (for Salty Snack). At the end, the program will display the size and type of the snack, the ID
                   and the total price.
*/
import java.util.*;
public class OrderSystem{
    public static void main(String[] args){
        //Create object of Scanner class
        Scanner input = new Scanner(System.in);
        //Displaying welcome message and menu
        System.out.println("\t\tWelcome to the Snack Ordering System!");
        System.out.println("\tMENU");
        System.out.println("1: Order a Snack");
        System.out.println("2: Exit program");
        System.out.print("Enter your selection: ");
        //User selection input:
        int selection = input.nextInt();
        //If the user select 1, the program will ask for the type of snack and the size
        while(selection == 1){
            //Create object of FruitSnack class
            FruitSnack fruitSnack = new FruitSnack();
            //Create object of SaltySnack class
            SaltySnack saltySnack = new SaltySnack();
            //Displaying snack choices
            System.out.print("Do you want a Fruit Snack(1) or Salty Snack(2)? ");
            //User snack selection input
            int snackSelection = input.nextInt();
            //Displaying size choices
            System.out.print("What size do you want? (S, M, L): ");
            //User size selection input
            String size = input.next();
            //This if statements is to check for the type of snack (citrus or nut) and set the price
            if(snackSelection == 1){
                System.out.print("Do you want a citrus Fruit Snack? (true/false): ");
                Boolean isCitrus = input.nextBoolean();
                //if statement to check if snack is citrus or not
                if(isCitrus){
                    fruitSnack.setPrice(isCitrus, size);
                    System.out.println("Your citrus Fruit Snack is: " + size);
                    System.out.println("ID = " + fruitSnack.getID());
                    System.out.println("Total price: " + String.format("%.2f",fruitSnack.getPrice()));
                }else{
                    fruitSnack.setPrice(isCitrus, size);
                    saltySnack.setPrice(size);
                    System.out.println("Your Fruit Snack is: " + size);
                    System.out.println("ID = " + fruitSnack.getID());
                    System.out.println("Total price: " + String.format("%.2f",fruitSnack.getPrice()));
                }
            }else{
                System.out.print("Do you want a nut Salty Snack? (true/false): ");
                Boolean isNut = input.nextBoolean();
                //if statement to check if snack has nuts or not
                if(isNut){
                    saltySnack.setPrice(isNut, size);
                    System.out.println("Your nut Salty Snack is: " + size);
                    System.out.println("ID = " + saltySnack.getID());
                    System.out.println("Total price: " + String.format("%.2f",saltySnack.getPrice()));
                }else{
                    saltySnack.setPrice(isNut, size);
                    System.out.println("Your Salty Snack is: " + size);
                    System.out.println("ID = " + saltySnack.getID());
                    System.out.println("Total price: " + String.format("%.2f",saltySnack.getPrice()));
                }
            }

            //Displaying menu again
            System.out.println("\tMENU");
            System.out.println("1: Order a Snack");
            System.out.println("2: Exit program");
            System.out.print("Enter your selection: ");
            //User selection input:
            selection = input.nextInt();
        }
        //If the user select 2, the program will gratefully exit
        System.out.print("Thank you for using the Snack Ordering System. Goodbye!");
        //Closing Scanner object
        input.close();
    }

}
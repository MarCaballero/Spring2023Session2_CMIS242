
/**
 * Week 6 Discussion
 * Nathan Roberts
 * 04/19/2023
 */
import java.util.Scanner;

public class DynamicBindingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print the available fruit options and prompt the user to choose one
        System.out.println("==========WELCOME TO THE FRUIT STAND=========="); // Maria Caballero - Added Intro Message
        System.out.println("\tChoose a fruit:");
        System.out.println("1. Apple");
        System.out.println("2. Orange");
        // Maria Caballero - Added an extra user input in case user wants to exit program
        System.out.println("3. Exit");
        System.out.print("> ");
        int fruitNumber = scanner.nextInt();

        while (fruitNumber > 0 && fruitNumber < 3) {
            // creating the fruit instance object
            Fruit fruit;
            // scan user input for amount to purchase
            int amount = 0;
            if (fruitNumber == 1) {
                System.out.print("How many apples would you like to purchase today? ");
                amount = scanner.nextInt();
                System.out.println(); // Maria Caballero - Added a new line for better readability
                if (amount == 0) {
                    // Maria Caballero - Default constructor when there was no purchase
                    fruit = new Fruit();
                    System.out.println("You did not make a purchase today.");
                    System.out.println("Your total purchase is = " + fruit.getTotalPrice());
                } else if (amount > 0){
                    // Maria Caballero - Calling the constructor with parameter
                    fruit = new Apple(amount);
                    // Here is where dynamic binding is happening
                    fruit.taste();
                } else {
                    // Maria Caballero - Added error message for invalid input
                    System.out.println("Invalid input.");
                }
            } else if (fruitNumber == 2) {
                System.out.print("How many oranges would you like to purchase today? ");
                amount = scanner.nextInt();
                System.out.println(); // Maria Caballero - Added a new line for better readability
                if (amount == 0) {
                    // Maria Caballero - Default constructor when there was no purchase
                    fruit = new Fruit();
                    System.out.println("You did not make a purchase today.");
                    System.out.println("Your total purchase is = " + fruit.getTotalPrice());
                } else if(amount > 0){
                    // Maria Caballero - Calling the constructor with parameter
                    fruit = new Orange(amount);
                    // Here is where dynamic binding is happening
                    fruit.taste();
                }else{
                    // Maria Caballero - Added error message for invalid input
                    System.out.println("Invalid input.");
                }
            }
            // Displaying the Menu again until user desires to exit
            System.out.println("==========WELCOME TO THE FRUIT STAND=========="); // Maria Caballero - Added Intro Message
            System.out.println("\tChoose a fruit:");
            System.out.println("1. Apple");
            System.out.println("2. Orange");
            // Maria Caballero - Added an extra user input in case user wants to exit program
            System.out.println("3. Exit");
            System.out.print("> ");
            fruitNumber = scanner.nextInt();
        }
        // closing Scanner object
        scanner.close();
        // Gratefully exiting the program
        System.out.println();
        System.out.println("Thank you for buying with us. See you soon!");
    }
}

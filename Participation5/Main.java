/**
 * Main class demonstrates functionality of Clothing (parent class),
 * Shirt (child class), and Pant (child class) classes.
 *
 * @author Megan Kundra
 *         CMIS 242, week 5 discussion post (topic: override and overload)
 *         April 13, 2023
 */
import java.util.*;
public class Main {
    /**
     * Main method creates Shirt and Pant objects, sets their attributes. The
     * program prints the Shirt and Pant objects' info after each change to
     * demonstrate the Clothing, Shirt and Pant classes' methods work as expected.
     *
     * @param args command-line arguments (not used)
     */

    public static void main(String[] args) {

        //Maria Caballero: I made some modifications like creating default instance of Shirt and Pant and adding a Scanner object
        Shirt redShirt = new Shirt();
        Pants bluePants = new Pants();
        //created scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("----------Welcome to the Clothing Store!----------");
        System.out.println("\tMENU");
        System.out.println("1. Shirt");
        System.out.println("2. Pants");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
        int option = input.nextInt();
        
        //Maria Caballero: I added a while loop to keep the program running until the user selects option 3
        while(option != 3){
            //Maria Caballero: I added a switch statement to handle the user's input
            switch(option){
                //case 1 is when the user selects option 1 which accounts for shirts
                case 1:
                    //OUTPUT                
                    System.out.println("----------Shirt----------");
                    System.out.print("Enter the size of the shirt (S,M,L): ");
                    //user input for size of shirt
                    String size = input.next();
                    System.out.print("Is the shirt long sleeve? (true/false): ");
                    //user input false or true for long sleeve
                    boolean isLongSleeve = input.nextBoolean();
                    //Maria Caballero: calling the default constructor but now with the user's input
                        //this is an example of overloading the constructor because we are using the same name of methods but different parameters
                    redShirt = new Shirt(size, isLongSleeve);
                    //Maria Caballero: calling the methods of the Shirt class
                    redShirt.displayType(isLongSleeve);
                    redShirt.displayPrice(isLongSleeve);
                    //printing a new line
                    System.out.println();
                    break;
                //case 2 is when the user selects option 2 which accounts for pants
                case 2:
                    //OUTPUT
                    System.out.println("----------Pants----------");
                    System.out.print("Enter the size of the pants (S,M,L): ");
                    //user input for size of pants
                    size = input.next();
                    System.out.print("Are the pants made of denim? (true/false): ");
                    //user input for false or true for denim pants
                    boolean isDenim = input.nextBoolean();
                    //Maria Caballero: calling the default constructor but now with the user's input
                        //this is an example of overloading the constructor because we are using the same name of methods but different parameters
                    bluePants = new Pants(size, isDenim);
                    //Maria Caballero: calling the methods of the Pants class
                    bluePants.displayType(isDenim);
                    bluePants.displayPrice(isDenim);
                    System.out.println();
                    break;
                //the default case 
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            //Displaying the menu again
            System.out.println("\tMENU");
            System.out.println("1. Shirt");
            System.out.println("2. Pants");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            option = input.nextInt();
        }
        //closing scanner object
        input.close();
        System.out.println("----------Thank you for shopping with us!----------");
    }

}
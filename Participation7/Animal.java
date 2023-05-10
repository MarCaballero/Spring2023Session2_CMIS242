/**
 * Animal class will be the Parent class to two children classes, it will share
 * 2 attributes and 2 methods with the subclasses
 * <p>
 * 
 * @author Nick Anderson
 * @since 3/24/2023
 *
 */

public class Animal {

	// Creating shared variables
	protected String name;
	protected int age;

	// Adding user defined error message
	// Added on 4/23/23
	// Constructor to assign attributes
	
	public Animal(String name, int age){
		/**
         * Maria Caballero - I added a try catch block to catch the exception if the user inputs a letter instead of a number.
         * Since this is the contructor that account for attributes like name and age for both Cat and Dog classes, I eliminated
         * the try catch blocks from the Cat and Dog classes and added it here. This way we get rid of redundant code.
         */
		this.age = age;
		this.name = name;
	}

	// Shared method for subclasses/child classes
	public void isSleeping() {
		System.out.println(name + " is sleeping.");
	}

	// Shared method for subclasses/child classes
	public void eating(String food) {
		System.out.println(name + " is eating" + food + ".");
	}

}

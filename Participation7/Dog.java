/**Dog class will be one of the two children classes, it will be extended from Animal class. <p>
 * The dog class will utilize the attributes and methods from the Animal class and have its own unique attribute and method
 * @author Nick Anderson
 * @since 3/24/2023
 */


// Extending Animal class to Dog class
public class Dog extends Animal {
	
	// Creating unique attribute to dog class
	private String breed;
	
	// User defined error message added on 4/23/23
	// Constructor to assign attributes and establishing super
	public Dog(String name, int age, String breed){
		super(name,age);
		this.breed = breed;
	}
	
	// Unique method to dog class
	public void isBarking() {
		System.out.println(name + " is barking.");
	}
	
	// Overloaded method
	public void isBarking(int times) {
		for (int i = 0; i < times; i++ ) {
			System.out.println("Woof!");
		}
	}
	
	// Unique method to dog class
	public void whatBreed() {
		System.out.println(name + " is a " + breed);
	}
}

import java.util.InputMismatchException;
import java.util.Scanner;

/**Main/driver class will call all the methods from each individual object class (Animal/Dog/Cat).
 * @author Nick Anderson
 * @since 3/24/2023
 */


public class Main_Disc_Wk3 {
	
	// Edit added on 4/23/23
	// Extending the user defined error message to be thrown
	// Will throw error message if age is 0 or under
	public static void main(String[] args) {
		//creating Scanner object
		Scanner input = new Scanner(System.in);
		// Create instance of objects (animals)
		// Utilizing the unique attributes for each class
		Dog dog = new Dog("", 0, "");
		Cat cat = new Cat("", 0, "");
		System.out.print("Enter if you have a dog or a cat? ");
		String animal = input.next();
		//Maria Caballero - I added try and catch methods for all the possible exceptions that could be thrown.
		try{
			if(animal.equalsIgnoreCase("dog")){
				System.out.print("Enter the name of your " + animal + ": ");
				String name = input.next();
				System.out.print("Enter the age of your " + animal + ": ");
				int age = input.nextInt();
				System.out.print("Enter the breed of your " + animal + ": ");
				String breed = input.next();
				dog = new Dog(name, age,breed);
				//this is to check for age input not being 0 or under. If it is, it will ask for a new input
				if(age <= 0){
					System.out.print("Invalid Input. Age cannot be 0 or under. Input again: ");
					age = input.nextInt();
					dog = new Dog(name, age,breed);
				}
				//new line
				System.out.println();
				// Utilizing Parent methods
				dog.eating(" The Farmers Dog ");
				// Utilizing unique methods to individual classes (dog/cat)
				dog.whatBreed();
				// Overloaded method in the dog class
				dog.isBarking(3);
			}else{
				System.out.print("Enter the name of your " + animal + ": ");
				String name = input.next();
				System.out.print("Enter the age of your " + animal + ": ");
				int age = input.nextInt();
				System.out.print("Enter the favorite toy of your " + animal + ": ");
				String favoriteToy = input.next();
				cat = new Cat(name, age,favoriteToy);
				//this is to check for age input not being 0 or under. If it is, it will ask for a new input
				if(age <= 0){
					System.out.print("Invalid Input. Age cannot be 0 or under. Input again: ");
					age = input.nextInt();
					cat = new Cat(name, age,favoriteToy);
				}
				//new line
				System.out.println();
				//Overriding method called in cat class
				cat.isSleeping();
				// Utilizing the unique method to the cat class
				cat.playing();
			}
		}catch(InputMismatchException e){
			throw new InputMismatchException("Invalid Input.Cannot be letters. Try again.");
		}
		//closing Scanner object
		input.close();
	}
}

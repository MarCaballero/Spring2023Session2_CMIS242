/**
 * Demonstrates the functionality of Game Console.
 * 
 * @author Kevin Pineda
 * modifications author: Maria Caballero
 */
public class ConsoleDriver {

	/**
	 * Main method creates a Game Console object. Sets its color and storage
	 * space. Program shows the initial storage and then the increased storage
	 * using the 'addMoreStorage' method.
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {


		// Creating Game Console object. -->Maria Caballero. I added the extra attribute.
		GameConsole playstationFour = new GameConsole("White", 500, "PlayStation");

		// Initial Storage printed using object toString.
		System.out.println(playstationFour);

		// Changing attribute of storage by adding more storage.
		playstationFour.addMoreStorage(400.0);
		System.out.println(playstationFour);
	}
}

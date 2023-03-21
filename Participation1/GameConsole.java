/*
 * Kevin Pineda
 * CMIS 242
 * 
 * Maria Caballero Modifications: 
 * 			I eliminated the code that was not used. Furthermore, I added an attribute called consoleType
 * 			and implemented it in the @Override method making the call of the instance of the object with 
 * 			the additional attribute so that it could also be display into the console.  
 * 
 * Creates an instance of a  Game console object.
 */
public class GameConsole {

	// attributes
	// Represents the color of the Game Console
	private String color;

	// Represents the amount of storage(in GB's) for the Game Console.
	private double storage;

	//Represents the type of console it is (Example: PlayStation, XBOX, Nintendo, etc)
	private String consoleType;

	// Constructorc
	/**
	 * Creates a game console by accepting a color, console type, and its
	 * storage it gigabytes.
	 * 
	 * @param color
	 * @param storage
	 */
	public GameConsole(String color, double storage, String consoleType) {
		this.color = color;
		this.storage = storage;
		this.consoleType = consoleType;
	}

	/**
	 * Adds more storage to the game console. If the storage is above its
	 * maximum capacity, a message will be displayed.
	 * 
	 * @param newStorage
	 */
	public void addMoreStorage(double newStorage) {
		double storageCheck = storage + newStorage;

		if (this.storage >= 1000 || storageCheck >= 1000) {
			System.out
					.println("Maximun storage allowed. Cannont add storage\n");
		} else {
			this.storage = storageCheck;
			System.out.println("Added storage successfully.\n");
		}
	}

	/**
	 * Override toString to give console information.
	 * 
	 * @override
	 */

	 //Maria Caballero - I added the consoleType output in the @Override method
	@Override
	public String toString() {
		return "The console has " + this.storage + " GB's of storage \nIt is " + this.consoleType + " and the color is "
				+ this.color + ".\n";
	}

}

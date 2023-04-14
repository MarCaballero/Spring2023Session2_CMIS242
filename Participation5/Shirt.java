/**
 * Shirt class is a child class to Clothing class and has local
 * attribute isLongSleeve, as well as get and set,
 * override toString() method and displayType() method.
 *
 * @author Megan Kundra
 *         CMIS 242, week 5 discussion post (topic: override and overload)
 *         April 13, 2023
 */

public class Shirt extends Clothing {

    // local attributes
    private boolean isLongSleeve; // true if shirt has long sleeves
    private final double PRICE = 46.99;

    /**
     * @Overloading default Constructor
     * 
     * Maria Caballero: I added a default constructor to Shirt class
     */
    public Shirt() {
        super("No size selected");
        this.isLongSleeve = false;
    }

    /**
     * Constructor for Shirt class
     */
    public Shirt(String size, boolean isLongSleeve) {
        super(size); // calls super class constructor
        this.isLongSleeve = isLongSleeve;
    }

    // ----------------Methods--------------
    /**
     * Overriding method
     * 
     * Display a message stating this is a shirt
     */
    @Override
    public void displayType(boolean isLongSleeve) {
        if(isLongSleeve) {
            System.out.println("You selected a long sleeve shirt of size: " + getSize());
        } else {
            System.out.println("You selected a shirt with no long sleeves of size: " + getSize());
        }
    }

    //Maria caballero: I added the displayPrice abstract method
    @Override
    public void displayPrice(boolean isLongSleeve) {
        if (isLongSleeve) {
            System.out.println("The price of the shirt is: " + String.format("%.2f", (PRICE + 6.99)));
        } else {
            System.out.println("The price of the shirt is: " + PRICE);
        }
    }

    /**
     * Setter method for isLongSleeve attribute.
     *
     * @param isLongSleeve the new isLongSleeve to set for the Shirt
     */
    public void setIsLongSleeve(boolean isLongSleeve) {
        this.isLongSleeve = isLongSleeve;
    }

    /**
     * Getter method for isLongSleeve attribute.
     *
     * @return the current isLongSleeve of Shirt
     */
    public boolean getIsLongSleeve() {
        return isLongSleeve;
    }

}
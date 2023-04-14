/**
 * Pants class is a child class to Clothing class and has local
 * attribute isDenim, as well as get and set, and override and overload
 * toString methods and a override displayType method.
 *
 * @author Megan Kundra
 *         CMIS 242, week 5 discussion post (topic: override and overload)
 *         April 13, 2023
 */

public class Pants extends Clothing {

    // local attributes
    private boolean isDenim; // true if pants are made of denim
    private final double PRICE = 89.99;

    /**
     * Overloading
     * Maria Caballero: I added a default constructor to Pants class
     */
    public Pants() {
        super("No size selected");
        this.isDenim = false;
    }

    /**
     * Constructor for Pants class
     */
    public Pants(String size, boolean isDenim) {
        super(size); // calls super class constructor
        this.isDenim = isDenim;
    }

    // ----------------Methods--------------
    /**
     * Overriding method
     * 
     * Display a message stating this is a pair of pants
     */
    @Override
    public void displayType(boolean isDenim) {
        if(isDenim) {
            System.out.println("You selected Levi denim pants of size: " + super.getSize());
        } else {
            System.out.println("You selected Gap pants of size: " + super.getSize());
        }
    }

    //Added the displayPrice abstract methos
    @Override
    public void displayPrice(boolean isDenim) {
        if (isDenim) {
            System.out.println("The price of the pants is: " + String.format("%.2f", (PRICE + 10.99)));
        } else {
            System.out.println("The price of the pants is: " + PRICE);
        }
    }

    /**
     * Setter method for isDenim attribute.
     *
     * @param isDenim the new isDenim to set for the Pants
     */
    public void setIsDenim(boolean isDenim) {
        this.isDenim = isDenim;
    }

    /**
     * Getter method for isDenim attribute.
     *
     * @return the current isDenim of Pants
     */
    public boolean getIsDenim() {
        return isDenim;
    }

}

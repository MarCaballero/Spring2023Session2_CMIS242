/**
 * Clothing class is an abstract class and is a parent
 * class with attribute size, as well as get and set methods,
 * abstract displayType() method, and abstract toString() method.
 *
 * @author Megan Kundra
 *         CMIS 242, week 5 discussion post (topic: override and overload)
 *         April 13, 2023
 */

public abstract class Clothing {

    // attributes
    private String size;
    //adding price attribute

    /**
     * Constructor for Clothing class
     */
    public Clothing(String size) {
        this.size = size;
    }

    // ----------------Methods--------------
    /**
     * Setter method for size attribute.
     *
     * @param size the new size to set for the Clothing
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Getter method for size attribute.
     *
     * @return the current size of Clothing
     */
    public String getSize() {
        return size;
    }

    /**
     * Abstract method for displaying the type of clothing.
     *
     * Child classes must implement this method to display a message stating what
     * type of clothing they are.
     */
    public abstract void displayType(boolean isTrueOrFalse);

    /**
     * Maria Caballero: I added this method to display the price of the clothing
     * Abstract method for displaying the price of the clothing.
     * 
     * Child classes must implement this method to display the price of the
     * clothing.
     */
    public abstract void displayPrice(boolean isDenim);

    /**
     * Abstract method for string containing attribute info.
     * 
     * Child classes must implement this method to create a string containing
     * attribute info.
     * 
     * @return string containing attribute info.
     */
}
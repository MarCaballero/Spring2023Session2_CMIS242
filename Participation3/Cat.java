/**
 * Cat class will be one of the two children classes, it will be extended from
 * Animal class.
 * <p>
 * The cat class will utilize the attributes and methods from the Animal class
 * and have its own unique attribute and method
 * 
 * @author Nick Anderson
 * @since 3/24/2023
 */

// Extending Animal class to Cat class
public class Cat extends Animal {

    // Creating unique attribute for Cat class
    private String favoriteToy;

    // Constructor to assign attributes and establishing super
    public Cat(String name, int age, boolean hasTag, String favoriteToy) {
        super(name, age, hasTag);
        this.favoriteToy = favoriteToy;
    }

    // Creating unique method for the Cat class
    public void playing() {
        System.out.println(name + " is playing with " + favoriteToy + ".");
    }
}

/**
 * Dog class will be one of the two children classes, it will be extended from
 * Animal class.
 * <p>
 * The dog class will utilize the attributes and methods from the Animal class
 * and have its own unique attribute and method
 * 
 * @author Nick Anderson
 * @since 3/24/2023
 */

// Extending Animal class to Dog class
public class Dog extends Animal {

    // Creating unique attribute to dog class
    private String breed;

    // Constructor to assign attributes and establishing super
    public Dog(String name, int age, boolean hasTag, String breed) {
        super(name, age, hasTag);
        this.breed = breed;
    }

    // Unique method to dog class
    public void barking() {
        System.out.println(name + " is barking.");
    }

    // Unique method to dog class
    public void whatBreed() {
        System.out.println(name + " is a " + breed);
    }
}

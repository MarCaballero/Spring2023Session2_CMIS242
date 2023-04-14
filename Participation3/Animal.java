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
    private boolean hasTag; //Maria Caballero - I added a boolean attribute to check if animal has a tag

    // Constructor to assign attributes
    public Animal(String name, int age, boolean hasTag) {
        this.name = name;
        this.age = age;
        this.hasTag = hasTag;
    }

    // Shared method for subclasses/child classes
    public void sleeping() {
        System.out.println(name + " is sleeping.");
    }

    // Shared method for subclasses/child classes
    public void eating(String food) {
        System.out.println(name + " is eating" + food + ".");
    }

    //Maria Caballero - I added a toString method to print out the name and age of the animal
    @Override
    public String toString() {
        return "Animal [name = " + name + ", age = " + age + ", hasTag = " + hasTag + "]";
    }

}

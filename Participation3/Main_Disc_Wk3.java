/**
 * Main/driver class will call all the methods from each individual object class
 * (Animal/Dog/Cat).
 * 
 * @author Nick Anderson
 * @since 3/24/2023
 */

public class Main_Disc_Wk3 {

    public static void main(String[] args) {

        // Create instance of objects (animals)
        // Utilizing the unique attributes for each class
        Dog dog = new Dog("Kiki", 12, true, "Boxer");
        Cat cat = new Cat("Simba", 5, false, "the Scrather");

        //Maria Caballero - I added a toString method to print out the name and age of the animal
        System.out.println(dog.toString());
        System.out.println(cat.toString());

        // Utilizing Parent methods
        System.out.println();
        dog.eating(" The Farmers Dog ");
        cat.sleeping();

        // Utilizing unique methods to individual classes (dog/cat)
        System.out.println();
        dog.whatBreed();
        dog.barking();
        cat.playing();
    }
}

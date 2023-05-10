import java.io.FileNotFoundException;
import java.io.IOException;
public class DriverManager {
    public static void main(String[] args){
        
        // create a default manager
        Manager manager = new Manager();

        // create some Pet objects
        Pet pet1 = new Dog(1234, "Fido", "OAJ781");
        Pet pet2 = new Snake(2895, "Slither", 5.5);
        Pet pet3 = new Dog(3756, "Rover", "ABC158");
        Pet pet4 = new Snake(4389, "Muchis", 3.2);

        // add pets to manager
        manager.addPet(pet1);
        manager.addPet(pet2);
        manager.addPet(pet3);
        manager.addPet(pet4);

        // display pets data to the console (in xml tag format)
        System.out.println("Pet objects add to the manager after startup");
        manager.displayAllPets();

        // try and catch method to catch FileNotFoundException
        try{
            // create a new pet file in the given directory "C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week8"
            manager.createPetFiles("C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\PetExampleReadFiles_Week8");
        }catch(IOException e){
            e.printStackTrace();  // print trace if there are issues
        }

        // try and catch method to catch FileNotFoundException
        try{
            //create a second new manager object loading the files
            Manager manager2 = new Manager("C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\PetExampleReadFiles_Week8");
            // display pets data to the console (in xml tag format)
            System.out.println("\nPet objects loaded by manager2 at startup");
            manager2.displayAllPets();
        }catch(FileNotFoundException e){
            e.printStackTrace();  // print trace if there are issues
        }
    }
}

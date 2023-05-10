import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Manager {

    // attribute
    private ArrayList<Pet> pets;

    // default contructor
    public Manager(){
        pets = new ArrayList<Pet>(); // initialize pets
    }

    /**
     * load all pet files from directory; assumes file name convention starts with pet type Dog or Snake followed by id
     * @param directory
     * If directory is not found, it will throw exception
     */

     public Manager(String directory) throws FileNotFoundException{

        // initialize empty pets list
        pets = new ArrayList<Pet>();

        // create file object for directory
        File directoryPath = new File(directory);

        // Get list of all files and directories
        File filesList[] = directoryPath.listFiles();

        // check if filesList is null, if so throw an exception
        if(filesList == null){
            throw new FileNotFoundException("Could not load, no such directory");
        }

        // declare local variables
        Pet pet = null;
        String line = null;
        Scanner scan = null;

        // loop through all files in directory
        for(File file : filesList){

            // check if file is a file and not a directory
            if(file.isFile()){

                // create scanner object for opening and read file lines
                scan = new Scanner(file);

                // loop through all lines in file as long as it hasNextLine is true
                while(scan.hasNextLine()){

                    // read line
                    line = scan.nextLine();

                    // check if line contains <Dog> tag
                    if(line.contains("<Dog>")){

                        // create new Dog object
                        pet = new Dog(line);

                    // check if line contains <Snake> tag
                    }else if(line.contains("<Snake>")){

                        // create new Snake object
                        pet = new Snake(line);

                    }

                    // add pet to pets list regardless if we have a dog or snake pet
                    pets.add(pet);
                }
            }
        }
     }
     
     // creates (or overwrites) a file for each pet object in pets attributes in the given directory
     public void createPetFiles(String directory) throws IOException{
        PrintWriter out = null;

        // for all Pet objects create files using Pet type and id values as filename
        for(int i = 0; i < pets.size(); i++){
            String fileName = directory + "/" + pets.get(i).getClass().getSimpleName() + "-" + pets.get(i).getId() + ".txt";
            out = new PrintWriter(new FileWriter(fileName)); // create/overwrites file
            out.println(pets.get(i).toString()); // write pet object to file
            out.flush(); // flush all the data to the file
            out.close(); // close the file/stream
        }
     }

     // display all stored pets on console
     public void displayAllPets(){
        for(int i = 0; i < pets.size(); i++){
            System.out.println(pets.get(i).toString());
        }
     }

     // add Pet object
    public void addPet(Pet pet){
        pets.add(pet);
    }
}

import java.io.*;
import java.util.*;

/**
 * This program reads a file named data.dat and writes the data to a file
 * named result.dat in reverse order. The input file should contain exactly
 * one real number per line
 */
public class ReverseFile{
    /**
     * @param args
     */
    public static void main(String[] args){
        Scanner data = null;    //To read data from file
        PrintWriter result = null;  //To write data to file
        ArrayList<Double> numbers = new ArrayList<Double>(); //An ArrayList to store the data

        try{    //Create the output stream
            result = new PrintWriter(new File("C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\data.dat.docx"));
        }catch (IOException e){
            System.out.println("Error opening the file result.dat");
            System.out.println(e.getMessage());
            return; //End the program
        }
        try{    //Create the input stream.
            data = new Scanner(new File("C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\result.dat.docx"));

            //Read all the data from the file and add them into the ArrayList
            while(data.hasNextDouble()){   //Read all double values until the end of the file
                numbers.add(data.nextDouble());
            }

            //Write the data to the output file in reverse order
            for(int i = numbers.size() - 1; i >= 0; i--){
                result.println(numbers.get(i));
            }
            result.flush(); //Flush the output stream into the file

            if(result.checkError()){
                System.out.println("Error writing to file result.dat");
            }else{
                System.out.println("The data has been written to the file result.dat");
            }

            //Note that PrintWriter doesn't throw exceptions on output errors
        }catch (FileNotFoundException e){
            System.out.println("File data.dat was not found");
            System.out.println(e.getMessage());
            return; //End the program
        }
    } //End of main 
} //End of class ReverseFile

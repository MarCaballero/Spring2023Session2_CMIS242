//CMIS-242
//Student Name: Maria Caballero
//Date: 03/15/2023
/*
 * *Program Summary:
 *          This program creates instance of class Student according to the amount of students the user
 *          wants to input and adds them into a list so that after, we can call the toString method at 
 *          the end and display each student with their respective averages.
 */


import java.util.*;

public class Main {
    public static void main(String[] args){
        //Scanner to read user input
        Scanner scan = new Scanner(System.in);
        System.out.print("How many students are you going to enter? ");
        //according to the number of students the user inputs, we will create instances of class Student
        int numOfStudents = scan.nextInt();
        //we add the Student isntances into the Student instance list
        ArrayList<Student> listOfStudents = new ArrayList<Student>(numOfStudents);
        String name;
        String lastName;
        double grade1;
        double grade2;
        double grade3;
        //for loop to input the necessary attributes to create the Student instance
        for(int i = 1; i <= numOfStudents; i++){
            System.out.print("Student " + i + " name: ");
            name = scan.next();
            System.out.print("     Last name: ");
            lastName = scan.next();
            System.out.print("       grade 1: ");
            grade1 = scan.nextInt();
            System.out.print("       grade 2: ");
            grade2 = scan.nextInt();
            System.out.print("       grade 3: ");
            grade3 = scan.nextInt();
            
            Student list = new Student(name, lastName, grade1, grade2, grade3);
            listOfStudents.add(list);
        }

        //after added into the list, we display each student with their respective final average
        for(int i = 0; i < listOfStudents.size(); i++){
            Student classroom = listOfStudents.get(i);
            System.out.println(classroom.toString() + String.format("%.2f", classroom.getAverage()) + "}");
        }

        //closing scanner
        scan.close();
    }  
}

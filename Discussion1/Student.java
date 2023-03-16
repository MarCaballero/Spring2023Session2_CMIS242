//Student class creates a new Student
public class Student{
    //attributes
    public String name; //Student's name
    public String lastName; //Student's last name
    public double grade1, grade2, grade3; //Student's grades

    //constructor to get and assign all attribute values
    public Student(String name, String lastName, double grade1, double grade2, double grade3){
        this.name = name;
        this.lastName = lastName;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    //class methods
    public double getAverage(){ //computes average test grade
        return (grade1 + grade2 + grade3) / 3;
    }

    //toString method return a String with the attributes given
    public String toString(){
        return "{" + name + " " + lastName + " - Average = ";
    }
}
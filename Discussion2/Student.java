//Student class creates a new Student
public class Student {
    // attributes
    private String name; // Student's name
    private String lastName; // Student's last name
    private double grade1, grade2, grade3; // Student's grades
    private double average; // Student's average

    // constructor to get and assign all attribute values
    public Student(String name, String lastName, double grade1, double grade2, double grade3) {
        this.name = name;
        this.lastName = lastName;
        if(this.isInvalidGrade(grade1) || this.isInvalidGrade(grade2) || this.isInvalidGrade(grade3)){
            System.out.println("You entered an invalid value for grades.");
            return;
        } else {
            this.grade1 = grade1;
            this.grade2 = grade2;
            this.grade3 = grade3;
        }
    }

    // class methods to get and set attributes
    public double getAverage() { // computes average test grade
        average = (grade1 + grade2 + grade3) / 3;
        return average;
    }
    public void setGrade1(double grade1) {
        if(this.isInvalidGrade(grade1)){
            System.out.println("You entered an invalid value for grade 1.");
            return;
        }
        this.grade1 = grade1;
    }
    public void setGrade2(double grade2) {
        if(this.isInvalidGrade(grade2)){
            System.out.println("You entered an invalid value for grade 2.");
            return;
        }
        this.grade2 = grade2;
    }
    public void setGrade3(double grade3) {
        if(this.isInvalidGrade(grade3)){
            System.out.println("You entered an invalid value for grade 3.");
            return;
        }
        this.grade3 = grade3;
    }
    
    @Override
    // toString method return a String with the attributes given
    public String toString() {
        return "{" + name + " " + lastName + " - Average = ";
    }

    //checking the student grades are not negative or equal to 0
    private boolean isInvalidGrade(double grade){
        if (grade <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
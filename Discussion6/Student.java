public class Student extends Person{
    private String school;
    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }
    /**
     * @Override
     * This method overrides the activity method in the Person class
     * =========Dynamic Binding for student instance===========
     */
    public void activity() {
        System.out.println("Student ID: " + this.getRand() + "\nStudent " + this.name + " is currently studying at " + this.school + ".");
    }
}

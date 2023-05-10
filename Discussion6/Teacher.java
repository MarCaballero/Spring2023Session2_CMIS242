public class Teacher extends Person{
    private String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    /**
     * @Override
     * This method overrides the activity method in the Person class
     * =========Dynamic Binding for teacher instance===========
     */
    public void activity(){
        System.out.println("Professor ID: " + super.getRand() + "\nProfessor " + this.name + " is currently teaching.");
    }
    /**
     * This method prints the subject taught by the teacher and it is a unique method for the Teacher class
     */
    public void subject(){
        System.out.println("Subjects taught: " + this.subject);
    }
}
import java.util.Random;
public class Person {
    //Attributes
    protected String name;
    protected int age;
    protected String subject;
    private Random rand;

    //Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        rand = new Random();
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getRand() {
        int rand = this.rand.nextInt(123456789);
        return rand;
    }

    //Method
    public void activity(){
        System.out.println("I am walking");
    }
}
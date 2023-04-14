public class Circle extends Shape{
    private double radius;
    public Circle(String color, String shape, double radius) {
        super(color, shape);
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }


}

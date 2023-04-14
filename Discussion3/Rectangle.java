public class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(String color, String shape, double width, double height) {
        super(color, shape);
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }
}
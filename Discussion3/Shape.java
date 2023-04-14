public class Shape {
    private String color;
    private String shape;
    public Shape(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }
    public double getArea() {
        return 0;
    }
    public String toString() {
        return ("Color: " + color + ", Shape: " + shape);
    }
}
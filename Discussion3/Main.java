public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("red","Circle", 5);
        shapes[1] = new Rectangle("blue", "Rectangle", 5, 10);
        shapes[2] = new Circle("green", "Circle", 10);
        for (Shape s : shapes) {
            System.out.println(s.toString() + ", Area: " + s.getArea());
        }
        


        
    }
}

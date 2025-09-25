package Shape;

public class TestShape {
    public static void main(String[] args) {
        // Upcast Circle to Shape
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println("Area: " + s1.getArea());
        System.out.println("Perimeter: " + s1.getPerimeter());
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());

        Circle c1 = (Circle) s1;
        System.out.println("Radius: " + c1.getRadius());

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println("Area: " + s3.getArea());

        Rectangle r1 = (Rectangle) s3;
        System.out.println("Length: " + r1.getLength());

        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println("Area: " + s4.getArea());

        Rectangle r2 = (Rectangle) s4;
        System.out.println(r2);

        Square sq1 = (Square) r2;
        System.out.println("Side: " + sq1.getSide());
    }
}
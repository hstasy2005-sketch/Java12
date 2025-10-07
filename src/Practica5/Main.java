package Practica5;

public class Main {
    public static void main(String[] args) {
        // Тестирование Printable
        Printable[] printables = {
                new Book("Java Programming"),
                new Shop("Computer Store"),
                new Book("Design Patterns")
        };

        System.out.println("=== Printable Test ===");
        for (Printable p : printables) {
            p.print();
        }

        // Тестирование Movable
        System.out.println("\n=== Movable Test ===");
        Movable circle = new MovableCircle(0, 0, 1, 1, 5);
        System.out.println("Before move: " + circle);
        circle.moveRight();
        circle.moveDown();
        System.out.println("After move: " + circle);

        // Тестирование Nameable
        System.out.println("\n=== Nameable Test ===");
        Nameable planet = new Planet("Earth");
        Nameable car = new Car("Toyota");
        System.out.println("Planet: " + planet.getName());
        System.out.println("Car: " + car.getName());

        // Тестирование Priceable
        System.out.println("\n=== Priceable Test ===");
        Priceable product = new Product("Laptop", 999.99);
        System.out.println("Price: $" + product.getPrice());
    }
}
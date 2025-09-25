package Movable;

public class TestMovable {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 1, 1);
        System.out.println("Original: " + point);
        point.moveUp();
        System.out.println("After moveUp: " + point);

        MovableCircle circle = new MovableCircle(0, 0, 2, 2, 5);
        System.out.println("Original: " + circle);
        circle.moveRight();
        System.out.println("After moveRight: " + circle);

        MovableRectangle rect = new MovableRectangle(0, 0, 4, 4, 1, 1);
        System.out.println("Original: " + rect);
        rect.moveDown();
        System.out.println("After moveDown: " + rect);
    }
}
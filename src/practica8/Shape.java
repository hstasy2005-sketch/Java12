package practica8;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    Color color;
    int x, y;
    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }
    public abstract void draw(Graphics g);
}

class Circle extends Shape {
    int radius;
    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }
}

class RectangleShape extends Shape {
    int width, height;
    public RectangleShape(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

public class RandomShapes extends JPanel {
    Shape[] shapes;

    public RandomShapes() {
        Random rand = new Random();
        shapes = new Shape[20];
        for (int i = 0; i < 20; i++) {
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            int x = rand.nextInt(400);
            int y = rand.nextInt(400);
            if (rand.nextBoolean())
                shapes[i] = new Circle(color, x, y, rand.nextInt(50) + 10);
            else
                shapes[i] = new RectangleShape(color, x, y, rand.nextInt(80) + 20, rand.nextInt(60) + 10);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes)
            s.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new RandomShapes());
        frame.setVisible(true);
    }
}

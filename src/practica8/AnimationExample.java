package practica8;
import javax.swing.*;
import java.awt.*;

public class AnimationExample extends JPanel {
    private Image[] frames;
    private int currentFrame = 0;

    public AnimationExample() {
        frames = new Image[]{
                new ImageIcon("frame1.png").getImage(),
                new ImageIcon("frame2.png").getImage(),
                new ImageIcon("frame3.png").getImage(),
                new ImageIcon("frame4.png").getImage()
        };

        Timer timer = new Timer(200, e -> {
            currentFrame = (currentFrame + 1) % frames.length;
            repaint();
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(frames[currentFrame], 50, 50, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new AnimationExample());
        frame.setVisible(true);
    }
}

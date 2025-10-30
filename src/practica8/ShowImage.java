package practica8;
import javax.swing.*;
import java.awt.*;

public class ShowImage extends JFrame {
    public ShowImage(String path) {
        super("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        ImageIcon icon = new ImageIcon(path);
        JLabel label = new JLabel(icon);
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите путь к изображению в аргументах командной строки!");
            System.exit(0);
        }
        new ShowImage(args[0]);
    }
}

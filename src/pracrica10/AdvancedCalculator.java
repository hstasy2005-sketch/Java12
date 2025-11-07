import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdvancedCalculator extends JFrame {
    private JTextField display;
    private double firstNumber, secondNumber, result;
    private String operator;

    public AdvancedCalculator() {
        super("Калькулятор");
        setLayout(new BorderLayout());
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Дисплей
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Панель кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "CE", "√", "x²"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Внутренний класс для обработки нажатий кнопок
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch(command) {
                case "0": case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9":
                case ".":
                    display.setText(display.getText() + command);
                    break;

                case "+": case "-": case "*": case "/":
                    firstNumber = Double.parseDouble(display.getText());
                    operator = command;
                    display.setText("");
                    break;

                case "=":
                    secondNumber = Double.parseDouble(display.getText());
                    switch(operator) {
                        case "+": result = firstNumber + secondNumber; break;
                        case "-": result = firstNumber - secondNumber; break;
                        case "*": result = firstNumber * secondNumber; break;
                        case "/":
                            if(secondNumber != 0) {
                                result = firstNumber / secondNumber;
                            } else {
                                display.setText("Ошибка");
                                return;
                            }
                            break;
                    }
                    display.setText(String.valueOf(result));
                    break;

                case "C":
                    display.setText("");
                    break;

                case "CE":
                    display.setText("");
                    firstNumber = secondNumber = result = 0;
                    break;

                case "√":
                    double num = Double.parseDouble(display.getText());
                    if(num >= 0) {
                        display.setText(String.valueOf(Math.sqrt(num)));
                    } else {
                        display.setText("Ошибка");
                    }
                    break;

                case "x²":
                    double squareNum = Double.parseDouble(display.getText());
                    display.setText(String.valueOf(squareNum * squareNum));
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new AdvancedCalculator();
    }
}
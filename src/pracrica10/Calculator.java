import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField jta1 = new JTextField(10);
    private JTextField jta2 = new JTextField(10);
    private JButton addButton = new JButton("Сложить");
    private JButton subtractButton = new JButton("Вычесть");
    private JButton multiplyButton = new JButton("Умножить");
    private JButton divideButton = new JButton("Делить");

    public Calculator() {
        super("Калькулятор");
        setLayout(new FlowLayout());
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("1-е число:"));
        add(jta1);
        add(new JLabel("2-е число:"));
        add(jta2);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        // Обработчики событий с использованием анонимных классов
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('+');
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('-');
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('*');
            }
        });

        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('/');
            }
        });

        setVisible(true);
    }

    private void calculate(char operation) {
        try {
            double x1 = Double.parseDouble(jta1.getText().trim());
            double x2 = Double.parseDouble(jta2.getText().trim());
            double result = 0;
            String operationText = "";

            switch(operation) {
                case '+':
                    result = x1 + x2;
                    operationText = "Сумма";
                    break;
                case '-':
                    result = x1 - x2;
                    operationText = "Разность";
                    break;
                case '*':
                    result = x1 * x2;
                    operationText = "Произведение";
                    break;
                case '/':
                    if(x2 == 0) {
                        JOptionPane.showMessageDialog(null, "Ошибка: деление на ноль!", "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = x1 / x2;
                    operationText = "Частное";
                    break;
            }

            JOptionPane.showMessageDialog(null, operationText + " = " + result, "Результат",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка в числах!", "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountrySelector extends JFrame {
    private JComboBox<String> countryComboBox;
    private JTextArea infoTextArea;

    private String[] countries = {"Россия", "США", "Германия", "Япония", "Бразилия"};
    private String[] countryInfo = {
            "Россия - крупнейшее государство в мире. Столица: Москва.",
            "США - федеративная республика. Столица: Вашингтон.",
            "Германия - страна в Центральной Европе. Столица: Берлин.",
            "Япония - островное государство в Восточной Азии. Столица: Токио.",
            "Бразилия - крупнейшее государство Южной Америки. Столица: Бразилиа."
    };

    public CountrySelector() {
        super("Выбор страны");
        setLayout(new BorderLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Панель выбора
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Выберите страну:"));
        countryComboBox = new JComboBox<>(countries);
        topPanel.add(countryComboBox);

        // Текстовая область с прокруткой
        infoTextArea = new JTextArea(10, 30);
        infoTextArea.setEditable(false);
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(infoTextArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Обработчик выбора
        countryComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = countryComboBox.getSelectedIndex();
                if(selectedIndex >= 0) {
                    infoTextArea.setText(countryInfo[selectedIndex]);
                }
            }
        });

        // Показать информацию о первой стране
        infoTextArea.setText(countryInfo[0]);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountrySelector();
    }
}
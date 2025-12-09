package practica14;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2_ReadFromFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            System.out.println("Содержимое файла 'output.txt':");
            System.out.println("===============================");

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.printf("%d: %s%n", lineNumber++, line);
            }

            System.out.println("===============================");
            System.out.println("Конец файла");

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            System.out.println("Файл 'output.txt' не найден или не может быть прочитан.");
        }
    }
}
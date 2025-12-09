package practica14;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1_WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для записи в файл:");
        System.out.println("(Для завершения ввода введите 'exit' на отдельной строке)");

        try (FileWriter writer = new FileWriter("output.txt")) {
            String line;

            while (true) {
                line = scanner.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                writer.write(line + "\n");
            }

            System.out.println("Информация успешно записана в файл 'output.txt'");

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
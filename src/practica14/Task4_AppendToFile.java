package practica14;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task4_AppendToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ДОБАВЛЕНИЕ ТЕКСТА В КОНЕЦ ФАЙЛА");
        System.out.println("================================");
        System.out.println("Введите текст для добавления в файл:");
        System.out.println("(Для завершения ввода введите 'stop' на отдельной строке)");

        try (FileWriter writer = new FileWriter("output.txt", true)) {
            String line;

            while (true) {
                line = scanner.nextLine();
                if (line.equals("stop")) {
                    break;
                }
                writer.write(line + "\n");
            }

            System.out.println("Текст успешно добавлен в конец файла!");

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
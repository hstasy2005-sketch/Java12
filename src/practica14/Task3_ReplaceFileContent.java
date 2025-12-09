package practica14;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task3_ReplaceFileContent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ЗАМЕНА СОДЕРЖИМОГО ФАЙЛА");
        System.out.println("=========================");
        System.out.println("Введите новый текст для файла:");
        System.out.println("(Для завершения ввода введите 'end' на отдельной строке)");

        try (FileWriter writer = new FileWriter("output.txt", false)) {
            String line;

            while (true) {
                line = scanner.nextLine();
                if (line.equals("end")) {
                    break;
                }
                writer.write(line + "\n");
            }

            System.out.println("Содержимое файла успешно заменено!");

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
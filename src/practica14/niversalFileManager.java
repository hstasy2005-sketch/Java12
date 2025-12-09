package practica14;
import java.io.*;
import java.util.Scanner;

public class UniversalFileManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "data.txt";

        while (true) {
            System.out.println("\n=== УПРАВЛЕНИЕ ФАЙЛАМИ ===");
            System.out.println("1. Записать информацию в файл (перезаписать)");
            System.out.println("2. Вывести информацию из файла на экран");
            System.out.println("3. Заменить информацию в файле");
            System.out.println("4. Добавить текст в конец файла");
            System.out.println("5. Выйти из программы");
            System.out.print("Выберите действие (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    writeToFile(fileName, false, scanner);
                    break;
                case 2:
                    readFromFile(fileName);
                    break;
                case 3:
                    writeToFile(fileName, false, scanner);
                    break;
                case 4:
                    writeToFile(fileName, true, scanner);
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void writeToFile(String fileName, boolean append, Scanner scanner) {
        String action = append ? "добавить в конец" : "записать";
        System.out.println("\nВведите текст для файла (введите 'END' на отдельной строке для завершения):");

        try (FileWriter writer = new FileWriter(fileName, append)) {
            while (true) {
                String line = scanner.nextLine();
                if (line.equals("END")) {
                    break;
                }
                writer.write(line + System.lineSeparator());
            }

            System.out.println("Текст успешно " + action + " файл '" + fileName + "'");

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void readFromFile(String fileName) {
        System.out.println("\nСодержимое файла '" + fileName + "':");
        System.out.println("====================================");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.printf("%3d: %s%n", lineNumber++, line);
            }

            if (lineNumber == 1) {
                System.out.println("Файл пуст.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        System.out.println("====================================");
    }
}
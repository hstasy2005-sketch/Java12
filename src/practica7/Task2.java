package practica7;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println("=== Задание 2 ===");
        System.out.print("Введите дату для сравнения (формат: дд.мм.гггг): ");

        try {
            String inputDateStr = scanner.nextLine();
            Date inputDate = dateFormatter.parse(inputDateStr);
            Date currentDate = new Date();

            System.out.println("Текущая дата: " + dateFormatter.format(currentDate));
            System.out.println("Введенная дата: " + dateFormatter.format(inputDate));

            // Сравнение дат
            if (inputDate.before(currentDate)) {
                System.out.println("Введенная дата РАНЬШЕ текущей");
            } else if (inputDate.after(currentDate)) {
                System.out.println("Введенная дата ПОЗЖЕ текущей");
            } else {
                System.out.println("Даты РАВНЫ");
            }

            // Сравнение через compareTo
            int comparison = inputDate.compareTo(currentDate);
            if (comparison < 0) {
                System.out.println("compareTo: введенная дата меньше текущей");
            } else if (comparison > 0) {
                System.out.println("compareTo: введенная дата больше текущей");
            } else {
                System.out.println("compareTo: даты равны");
            }

        } catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты!");
        } finally {
            scanner.close();
        }
    }
}

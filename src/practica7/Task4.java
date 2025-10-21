package practica7;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 4 ===");

        try {
            // Ввод данных
            System.out.print("Введите год: ");
            int year = scanner.nextInt();

            System.out.print("Введите месяц (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Введите число: ");
            int day = scanner.nextInt();

            System.out.print("Введите часы (0-23): ");
            int hours = scanner.nextInt();

            System.out.print("Введите минуты (0-59): ");
            int minutes = scanner.nextInt();

            // Создание объекта Date (устаревший способ)
            @SuppressWarnings("deprecation")
            Date date = new Date(year - 1900, month - 1, day, hours, minutes);

            // Создание объекта Calendar (рекомендуемый способ)
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, hours);
            calendar.set(Calendar.MINUTE, minutes);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            // Вывод результатов
            System.out.println("\nРезультаты:");
            System.out.println("Объект Date: " + date);
            System.out.println("Объект Calendar: " + calendar.getTime());
            System.out.println("Год из Calendar: " + calendar.get(Calendar.YEAR));
            System.out.println("Месяц из Calendar: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("День из Calendar: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("Часы из Calendar: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты из Calendar: " + calendar.get(Calendar.MINUTE));

        } catch (Exception e) {
            System.out.println("Ошибка ввода данных!");
        } finally {
            scanner.close();
        }
    }

    }

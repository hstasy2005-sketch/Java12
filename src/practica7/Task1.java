package practica7;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Task1 {
    public static void main(String[] args) {
        // Получаем дату получения задания (текущее время)
        long startTime = System.currentTimeMillis();
        Date startDate = new Date(startTime);

        // Имитируем выполнение работы
        try {
            Thread.sleep(2000); // 2 секунды на выполнение
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получаем дату сдачи задания
        long endTime = System.currentTimeMillis();
        Date endDate = new Date(endTime);

        // Форматируем вывод
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("=== Задание 1 ===");
        System.out.println("Фамилия разработчика: Иванов");
        System.out.println("Дата и время получения задания: " + dateFormatter.format(startDate));
        System.out.println("Дата и время сдачи задания: " + dateFormatter.format(endDate));
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }
}


package practica7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task5 {
    private static final int OPERATION_COUNT = 100000;

    public static void main(String[] args) {
        System.out.println("=== Задание 5 ===");
        System.out.println("Сравнение производительности ArrayList vs LinkedList");
        System.out.println("Количество операций: " + OPERATION_COUNT);
        System.out.println();

        // Тестирование добавления в конец
        testAddToEnd();

        // Тестирование добавления в начало
        testAddToBeginning();

        // Тестирование вставки в середину
        testInsertInMiddle();

        // Тестирование удаления из начала
        testRemoveFromBeginning();

        // Тестирование удаления из конца
        testRemoveFromEnd();

        // Тестирование поиска
        testSearch();
    }

    private static void testAddToEnd() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.nanoTime() - startTime;

        System.out.println("Добавление в конец:");
        System.out.printf("ArrayList:  %12d нс\n", arrayListTime);
        System.out.printf("LinkedList: %12d нс\n", linkedListTime);
        printComparison(arrayListTime, linkedListTime);
    }

    private static void testAddToBeginning() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; i++) {
            arrayList.add(0, i);
        }
        long arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; i++) {
            linkedList.add(0, i);
        }
        long linkedListTime = System.nanoTime() - startTime;

        System.out.println("\nДобавление в начало:");
        System.out.printf("ArrayList:  %12d нс\n", arrayListTime);
        System.out.printf("LinkedList: %12d нс\n", linkedListTime);
        printComparison(arrayListTime, linkedListTime);
    }

    private static void testInsertInMiddle() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Предварительное заполнение
        for (int i = 0; i < OPERATION_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT / 10; i++) {
            arrayList.add(OPERATION_COUNT / 2, i);
        }
        long arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT / 10; i++) {
            linkedList.add(OPERATION_COUNT / 2, i);
        }
        long linkedListTime = System.nanoTime() - startTime;

        System.out.println("\nВставка в середину:");
        System.out.printf("ArrayList:  %12d нс\n", arrayListTime);
        System.out.printf("LinkedList: %12d нс\n", linkedListTime);
        printComparison(arrayListTime, linkedListTime);
    }

    private static void testRemoveFromBeginning() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Предварительное заполнение
        for (int i = 0; i < OPERATION_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        long arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        while (!linkedList.isEmpty()) {
            linkedList.remove(0);
        }
        long linkedListTime = System.nanoTime() - startTime;

        System.out.println("\nУдаление из начала:");
        System.out.printf("ArrayList:  %12d нс\n", arrayListTime);
        System.out.printf("LinkedList: %12d нс\n", linkedListTime);
        printComparison(arrayListTime, linkedListTime);
    }

    private static void testRemoveFromEnd() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Предварительное заполнение
        for (int i = 0; i < OPERATION_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        long arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        while (!linkedList.isEmpty()) {
            linkedList.remove(linkedList.size() - 1);
        }
        long linkedListTime = System.nanoTime() - startTime;

        System.out.println("\nУдаление из конца:");
        System.out.printf("ArrayList:  %12d нс\n", arrayListTime);
        System.out.printf("LinkedList: %12d нс\n", linkedListTime);
        printComparison(arrayListTime, linkedListTime);
    }

    private static void testSearch() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        // Предварительное заполнение
        for (int i = 0; i < OPERATION_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT / 10; i++) {
            arrayList.contains(random.nextInt(OPERATION_COUNT));
        }
        long arrayListTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT / 10; i++) {
            linkedList.contains(random.nextInt(OPERATION_COUNT));
        }
        long linkedListTime = System.nanoTime() - startTime;

        System.out.println("\nПоиск элемента:");
        System.out.printf("ArrayList:  %12d нс\n", arrayListTime);
        System.out.printf("LinkedList: %12d нс\n", linkedListTime);
        printComparison(arrayListTime, linkedListTime);
    }

    private static void printComparison(long time1, long time2) {
        if (time1 < time2) {
            System.out.printf("ArrayList быстрее в %.2f раз\n", (double)time2 / time1);
        } else {
            System.out.printf("LinkedList быстрее в %.2f раз\n", (double)time1 / time2);
        }
    }
}
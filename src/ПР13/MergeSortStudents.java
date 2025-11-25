import java.util.ArrayList;
import java.util.List;

public class MergeSortStudents {

    // Сортировка слиянием для списка студентов
    public static List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) {
            return list;
        }

        // Разделяем список на две части
        int middle = list.size() / 2;
        List<Student> left = new ArrayList<>(list.subList(0, middle));
        List<Student> right = new ArrayList<>(list.subList(middle, list.size()));

        // Рекурсивно сортируем каждую часть
        left = mergeSort(left);
        right = mergeSort(right);

        // Объединяем отсортированные части
        return merge(left, right);
    }

    // Метод слияния двух отсортированных списков
    private static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Добавляем оставшиеся элементы
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }

    // Объединение двух списков с последующей сортировкой
    public static List<Student> mergeTwoLists(List<Student> list1, List<Student> list2) {
        List<Student> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);

        return mergeSort(merged);
    }

    public static void main(String[] args) {
        // Первый список студентов
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(2, "Петр Смирнов", 4.5));
        list1.add(new Student(5, "Елена Кузнецова", 4.0));
        list1.add(new Student(1, "Анна Сидорова", 4.8));

        // Второй список студентов
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(4, "Мария Иванова", 3.9));
        list2.add(new Student(3, "Иван Петров", 4.2));
        list2.add(new Student(6, "Алексей Волков", 4.7));

        System.out.println("Первый список:");
        for (Student s : list1) {
            System.out.println(s);
        }

        System.out.println("\nВторой список:");
        for (Student s : list2) {
            System.out.println(s);
        }

        // Объединяем и сортируем
        List<Student> mergedList = mergeTwoLists(list1, list2);

        System.out.println("\nОбъединенный и отсортированный список:");
        for (Student s : mergedList) {
            System.out.println(s);
        }
    }
}
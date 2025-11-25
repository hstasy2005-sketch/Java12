import java.util.Comparator;

// Класс для сортировки студентов по GPA (по убыванию)
class SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        // Сортировка по убыванию GPA
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    // Быстрая сортировка (QuickSort)
    public void quickSort(Student[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(Student[] array, int low, int high) {
        Student pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Используем Comparator для сравнения
            if (compare(array[j], pivot) < 0) {
                i++;
                // Меняем местами
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Меняем местами pivot
        Student temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Метод для удобства
    public void sort(Student[] array) {
        quickSort(array, 0, array.length - 1);
    }
}

// Тестирование
public class GPASortingTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1, "Анна Сидорова", 4.8),
                new Student(2, "Петр Смирнов", 4.5),
                new Student(3, "Иван Петров", 4.2),
                new Student(4, "Мария Иванова", 3.9),
                new Student(5, "Елена Кузнецова", 4.0)
        };

        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        System.out.println("До сортировки по GPA:");
        for (Student s : students) {
            System.out.println(s);
        }

        sorter.sort(students);

        System.out.println("\nПосле сортировки по GPA (по убыванию):");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
// Класс Student реализующий Comparable
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', gpa=" + gpa + "}";
    }
}

// Тестовый класс с сортировкой вставками
public class TestSorting {

    // Сортировка вставками для массива Comparable объектов
    public static void insertionSort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            Comparable current = array[i];
            int j = i - 1;

            // Сдвигаем элементы, пока не найдем правильную позицию
            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        // Создаем массив студентов
        Student[] students = {
                new Student(3, "Иван Петров", 4.2),
                new Student(1, "Анна Сидорова", 4.8),
                new Student(4, "Мария Иванова", 3.9),
                new Student(2, "Петр Смирнов", 4.5),
                new Student(5, "Елена Кузнецова", 4.0)
        };

        System.out.println("До сортировки:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Сортируем по ID (используется compareTo из Student)
        insertionSort(students);

        System.out.println("\nПосле сортировки по ID:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
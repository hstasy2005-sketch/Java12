// Пример собственного класса с реализацией Comparable
class Course implements Comparable<Course> {
    private String code;
    private String name;
    private int credits;
    private int semester;

    public Course(String code, String name, int credits, int semester) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.semester = semester;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getSemester() {
        return semester;
    }

    // Собственная реализация compareTo
    @Override
    public int compareTo(Course other) {
        // Сначала сравниваем по семестру
        int semesterCompare = Integer.compare(this.semester, other.semester);
        if (semesterCompare != 0) {
            return semesterCompare;
        }

        // Если семестры одинаковые, сравниваем по количеству кредитов (по убыванию)
        int creditsCompare = Integer.compare(other.credits, this.credits);
        if (creditsCompare != 0) {
            return creditsCompare;
        }

        // Если кредиты одинаковые, сравниваем по коду курса
        return this.code.compareTo(other.code);
    }

    @Override
    public String toString() {
        return String.format("Course{code='%s', name='%s', credits=%d, semester=%d}",
                code, name, credits, semester);
    }
}

// Тестирование собственной реализации Comparable
public class ComparableExample {

    // Универсальный метод сортировки для любых Comparable объектов
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Меняем местами
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Создаем массив курсов
        Course[] courses = {
                new Course("CS101", "Введение в программирование", 4, 1),
                new Course("MA201", "Линейная алгебра", 5, 2),
                new Course("CS201", "Объектно-ориентированное программирование", 5, 2),
                new Course("PH101", "Физика", 4, 1),
                new Course("CS301", "Алгоритмы и структуры данных", 6, 3),
                new Course("MA101", "Математический анализ", 5, 1)
        };

        System.out.println("Курсы до сортировки:");
        for (Course c : courses) {
            System.out.println(c);
        }

        // Сортируем с использованием нашей реализации compareTo
        bubbleSort(courses);

        System.out.println("\nКурсы после сортировки:");
        System.out.println("(по семестру ↑, по кредитам ↓, по коду ↑)");
        for (Course c : courses) {
            System.out.println(c);
        }

        // Демонстрация полиморфизма
        System.out.println("\nДемонстрация полиморфизма:");

        Comparable[] objects = new Comparable[3];
        objects[0] = new Course("CS101", "Программирование", 4, 1);
        objects[1] = new Student(1, "Иван Иванов", 4.5);
        objects[2] = new Course("MA101", "Математика", 5, 1);

        System.out.println("Разные объекты, реализующие Comparable:");
        for (Comparable obj : objects) {
            System.out.println(obj);
        }
    }
}
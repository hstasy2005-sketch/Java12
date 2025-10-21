package practica7;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Student {
    private String name;
    private Date birthDate;

    public Student(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    // Метод для форматированного вывода даты рождения
    public String getFormattedBirthDate(String formatType) {
        SimpleDateFormat formatter;

        switch (formatType.toLowerCase()) {
            case "short":
                formatter = new SimpleDateFormat("dd.MM.yy");
                break;
            case "medium":
                formatter = new SimpleDateFormat("dd MMM yyyy");
                break;
            case "full":
                formatter = new SimpleDateFormat("EEEE, d MMMM yyyy 'года'");
                break;
            default:
                formatter = new SimpleDateFormat("dd.MM.yyyy");
        }

        return formatter.format(birthDate);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', birthDate=" +
                new SimpleDateFormat("dd.MM.yyyy").format(birthDate) + "}";
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
}

public class Task3 {
    public static void main(String[] args) {
        System.out.println("=== Задание 3 ===");

        // Создаем студента с датой рождения
        Date birthDate = new Date(103, 7, 15); // 15 августа 2003 года
        Student student = new Student("Петр Сидоров", birthDate);

        // Выводим в разных форматах
        System.out.println("Короткий формат: " + student.getFormattedBirthDate("short"));
        System.out.println("Средний формат: " + student.getFormattedBirthDate("medium"));
        System.out.println("Полный формат: " + student.getFormattedBirthDate("full"));
        System.out.println("Метод toString(): " + student.toString());
    }
}

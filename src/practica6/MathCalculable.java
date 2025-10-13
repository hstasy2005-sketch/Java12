package practica6;

public class MathCalculable {
    // Интерфейс MathCalculable
    public interface MathCalculable {
        double PI = 3.141592653589793;

        double power(double base, double exponent);
        double complexModulus(double real, double imaginary);
    }

    // Класс MathFunc
    public class MathFunc implements MathCalculable {

        @Override
        public double power(double base, double exponent) {
            return Math.pow(base, exponent);
        }

        @Override
        public double complexModulus(double real, double imaginary) {
            return Math.sqrt(real * real + imaginary * imaginary);
        }

        // Метод для вычисления длины окружности
        public double calculateCircleLength(double radius) {
            return 2 * PI * radius;
        }

        // Метод для вычисления площади круга
        public double calculateCircleArea(double radius) {
            return PI * power(radius, 2);
        }
    }

    // Тестирование
    public class MathTest {
        public static void main(String[] args) {
            MathCalculable mc = new MathFunc(); // правильно
            // MathCalculable mc2 = new MathCalculable(); // ошибка!

            MathFunc math = new MathFunc();
            System.out.println("Длина окружности: " + math.calculateCircleLength(5));
            System.out.println("Модуль комплексного числа: " + math.complexModulus(3, 4));
            System.out.println("2^8 = " + math.power(2, 8));
        }
    }
}

package practica6;

public class StringProcessor {
    // Интерфейс StringProcessor
    public interface StringProcessor {
        int countCharacters(String s);
        String oddPositionCharacters(String s);
        String reverseString(String s);
    }

    // Класс ProcessStrings
    public class ProcessStrings implements StringProcessor {

        @Override
        public int countCharacters(String s) {
            return s.length();
        }

        @Override
        public String oddPositionCharacters(String s) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) { // позиции 0, 2, 4... (в программировании индексация с 0)
                    result.append(s.charAt(i));
                }
            }
            return result.toString();
        }

        @Override
        public String reverseString(String s) {
            return new StringBuilder(s).reverse().toString();
        }
    }

    // Тестирование
    public class StringTest {
        public static void main(String[] args) {
            StringProcessor processor = new ProcessStrings();
            String testString = "Hello World";

            System.out.println("Исходная строка: " + testString);
            System.out.println("Количество символов: " + processor.countCharacters(testString));
            System.out.println("Символы на нечетных позициях: " + processor.oddPositionCharacters(testString));
            System.out.println("Инвертированная строка: " + processor.reverseString(testString));
        }
    }
}

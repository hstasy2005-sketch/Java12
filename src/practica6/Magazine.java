package practica6;

public class Magazine {
        public static void printMagazines(Printable[] printable) {
            for (Printable item : printable) {
                if (item instanceof Journal) {
                    // В данном случае Journal - это журнал
                    item.print();
                }
            }
        }
    }

    // Класс Book (дополнение)
    public class Book {
        public static void printBooks(Printable[] printable) {
            for (Printable item : printable) {
                if (item instanceof Book) {
                    item.print();
                }
            }
        }
    }

    // Пример использования
    public class PrintableTest {
        public static void main(String[] args) {
            Printable[] items = {
                    new Book("Война и мир", "Л. Н. Толстой", 1863),
                    new Journal("Хакер"),
                    new Book("Отцы и дети", "И. Тургенев", 1862),
                    new Journal("Компьютерра")
            };

            System.out.println("=== Все журналы ===");
            Magazine.printMagazines(items);

            System.out.println("=== Все книги ===");
            Book.printBooks(items);
        }
    }
}

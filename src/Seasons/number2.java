package Seasons;

public class number2 {
    public enum Size {
        XXS(32, "Детский размер"),
        XS(34, "Взрослый размер"),
        S(36, "Взрослый размер"),
        M(38, "Взрослый размер"),
        L(40, "Взрослый размер");

        private final int euroSize;
        private final String description;

        Size(int euroSize, String description) {
            this.euroSize = euroSize;
            this.description = description;
        }

        public int getEuroSize() {
            return euroSize;
        }

        public String getDescription() {
            return description;
        }
    }

    // Интерфейсы
    public interface MenClothing {
        void dressMan();
    }

    public interface WomenClothing {
        void dressWomen();
    }

    // Абстрактный класс одежды
    public static abstract class Clothes {
        protected Size size;
        protected double cost;
        protected String color;

        public Clothes(Size size, double cost, String color) {
            this.size = size;
            this.cost = cost;
            this.color = color;
        }

        // Геттеры
        public Size getSize() { return size; }
        public double getCost() { return cost; }
        public String getColor() { return color; }
    }

    // Классы одежды
    public static class TShirt extends Clothes implements MenClothing, WomenClothing {
        public TShirt(Size size, double cost, String color) {
            super(size, cost, color);
        }

        @Override
        public void dressMan() {
            System.out.println("Одеваем мужчину в футболку: " +
                    getColor() + ", размер " + getSize() +
                    ", цена " + getCost());
        }

        @Override
        public void dressWomen() {
            System.out.println("Одеваем женщину в футболку: " +
                    getColor() + ", размер " + getSize() +
                    ", цена " + getCost());
        }
    }

    public static class Pants extends Clothes implements MenClothing, WomenClothing {
        public Pants(Size size, double cost, String color) {
            super(size, cost, color);
        }

        @Override
        public void dressMan() {
            System.out.println("Одеваем мужчину в штаны: " +
                    getColor() + ", размер " + getSize() +
                    ", цена " + getCost());
        }

        @Override
        public void dressWomen() {
            System.out.println("Одеваем женщину в штаны: " +
                    getColor() + ", размер " + getSize() +
                    ", цена " + getCost());
        }
    }

    public static class Skirt extends Clothes implements WomenClothing {
        public Skirt(Size size, double cost, String color) {
            super(size, cost, color);
        }

        @Override
        public void dressWomen() {
            System.out.println("Одеваем женщину в юбку: " +
                    getColor() + ", размер " + getSize() +
                    ", цена " + getCost());
        }
    }

    public static class Tie extends Clothes implements MenClothing {
        public Tie(Size size, double cost, String color) {
            super(size, cost, color);
        }

        @Override
        public void dressMan() {
            System.out.println("Одеваем мужчину в галстук: " +
                    getColor() + ", размер " + getSize() +
                    ", цена " + getCost());
        }
    }

    // Класс Ателье
    public static class Atelier {
        public void dressWomen(Clothes[] clothes) {
            System.out.println("Женская одежда:");
            for (Clothes cloth : clothes) {
                if (cloth instanceof WomenClothing) {
                    ((WomenClothing) cloth).dressWomen();
                }
            }
        }

        public void dressMan(Clothes[] clothes) {
            System.out.println("Мужская одежда:");
            for (Clothes cloth : clothes) {
                if (cloth instanceof MenClothing) {
                    ((MenClothing) cloth).dressMan();
                }
            }
        }

        public static void main(String[] args) {
            // Создаем массив одежды
            Clothes[] clothes = {
                    new TShirt(Size.M, 25.0, "Красный"),
                    new Pants(Size.L, 45.0, "Синий"),
                    new Skirt(Size.S, 35.0, "Черный"),
                    new Tie(Size.M, 15.0, "Зеленый")
            };

            Atelier atelier = new Atelier();
            atelier.dressWomen(clothes);
            System.out.println();
            atelier.dressMan(clothes);
        }
    }
}

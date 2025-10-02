package Seasons;

public class computer {
    // Перечисление марок компьютеров
    public enum ComputerBrand {
        DELL, HP, LENOVO, ASUS, ACER, APPLE
    }

    // Класс процессора
    public static class Processor {
        private String model;
        private double frequency; // в GHz
        private int cores;

        public Processor(String model, double frequency, int cores) {
            this.model = model;
            this.frequency = frequency;
            this.cores = cores;
        }

        // Геттеры и сеттеры
        public String getModel() { return model; }
        public double getFrequency() { return frequency; }
        public int getCores() { return cores; }

        @Override
        public String toString() {
            return "Processor: " + model + ", " + frequency + " GHz, " + cores + " cores";
        }
    }

    // Класс памяти
    public static class Memory {
        private String type;
        private int size; // в GB
        private double frequency; // в MHz

        public Memory(String type, int size, double frequency) {
            this.type = type;
            this.size = size;
            this.frequency = frequency;
        }

        // Геттеры и сеттеры
        public String getType() { return type; }
        public int getSize() { return size; }
        public double getFrequency() { return frequency; }

        @Override
        public String toString() {
            return "Memory: " + size + "GB " + type + " " + frequency + " MHz";
        }
    }

    // Класс монитора
    public static class Monitor {
        private String model;
        private double size; // в дюймах
        private String resolution;

        public Monitor(String model, double size, String resolution) {
            this.model = model;
            this.size = size;
            this.resolution = resolution;
        }

        // Геттеры и сеттеры
        public String getModel() { return model; }
        public double getSize() { return size; }
        public String getResolution() { return resolution; }

        @Override
        public String toString() {
            return "Monitor: " + model + ", " + size + "\", " + resolution;
        }
    }

    // Основной класс компьютера
    public static class Computer {
        private ComputerBrand brand;
        private Processor processor;
        private Memory memory;
        private Monitor monitor;
        private double price;

        public Computer(ComputerBrand brand, Processor processor, Memory memory, Monitor monitor, double price) {
            this.brand = brand;
            this.processor = processor;
            this.memory = memory;
            this.monitor = monitor;
            this.price = price;
        }

        // Геттеры
        public ComputerBrand getBrand() { return brand; }
        public Processor getProcessor() { return processor; }
        public Memory getMemory() { return memory; }
        public Monitor getMonitor() { return monitor; }
        public double getPrice() { return price; }

        public void displayInfo() {
            System.out.println("Computer: " + brand);
            System.out.println("Price: $" + price);
            System.out.println(processor);
            System.out.println(memory);
            System.out.println(monitor);
        }

        public static void main(String[] args) {
            Processor processor = new Processor("Intel Core i7", 3.2, 8);
            Memory memory = new Memory("DDR4", 16, 3200);
            Monitor monitor = new Monitor("Dell UltraSharp", 27.0, "2560x1440");

            Computer computer = new Computer(ComputerBrand.DELL, processor, memory, monitor, 1200.0);
            computer.displayInfo();
        }
    }
}

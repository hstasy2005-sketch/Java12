package Seasons;

public enum Season {
    WINTER("Зима", -5, "Холодное время года"),
    SPRING("Весна", 10, "Холодное время года"),
    SUMMER("Лето", 25, "Теплое время года"),
    AUTUMN("Осень", 8, "Холодное время года");

    private final String name;
    private final double averageTemperature;
    private final String description;

    Season(String name, double averageTemperature, String description) {
        this.name = name;
        this.averageTemperature = averageTemperature;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public String getDescription() {
        return description;
    }

    public static void printSeasonInfo(Season season) {
        switch (season) {
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }
}
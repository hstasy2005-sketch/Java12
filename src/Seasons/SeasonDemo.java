package Seasons;

public class SeasonDemo {
    public static void main(String[] args) {
        //  Создать переменную с любимым временем года
        Season favoriteSeason = Season.SUMMER;
        System.out.println("Мое любимое время года: " + favoriteSeason.getName());
        System.out.println("Средняя температура: " + favoriteSeason.getAverageTemperature());
        System.out.println("Описание: " + favoriteSeason.getDescription());

        // Использование switch
        Season.printSeasonInfo(favoriteSeason);

        //  Цикл с распечаткой всех времен года
        System.out.println("\nВсе времена года:");
        for (Season season : Season.values()) {
            System.out.println("Время года: " + season.getName() +
                    ", Средняя температура: " + season.getAverageTemperature() +
                    "°C, Описание: " + season.getDescription());
        }
    }
}
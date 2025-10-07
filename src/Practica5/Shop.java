package Practica5;

public class Shop implements Printable {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Магазин: " + name);
    }
}
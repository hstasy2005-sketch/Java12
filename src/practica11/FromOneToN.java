package practica11; // задача 2

public class FromOneToN {
    public static void printNumbers(int n) {
        if (n == 0) return;
        printNumbers(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printNumbers(5);
    }
}

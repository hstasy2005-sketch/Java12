package practica11; //задача 10

public class ReverseNumber {
    public static int reverse(int n, int acc) {
        if (n == 0) return acc;
        return reverse(n / 10, acc * 10 + n % 10);
    }

    public static void main(String[] args) {
        System.out.println(reverse(12345, 0)); // 54321
    }
}

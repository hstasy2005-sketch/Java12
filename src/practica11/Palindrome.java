package practica11; // задача 8

public class Palindrome {
    public static String isPalindrome(String s) {
        if (s.length() <= 1) return "YES";
        if (s.charAt(0) != s.charAt(s.length() - 1)) return "NO";
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("radar")); // YES
        System.out.println(isPalindrome("hello")); // NO
    }
}

package practica12;
public class Exception1 {
    public void exceptionDemo() {
        try {
            System.out.println(2 / 0); // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }
}
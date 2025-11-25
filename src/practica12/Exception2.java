package practica12;

public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");

        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString); // NumberFormatException
            System.out.println(2 / i); // ArithmeticException
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        } finally {
            myScanner.close();
        }
    }
}
import java.util.Scanner;

public class NTHFIBONACCI {

    public static int iterativeFibonacci(int n) {
        if (n <= 0) return 0; // Fibonacci(0) = 0
        if (n == 1) return 1; // Fibonacci(1) = 1

        int a = 0; // F(0)
        int b = 1; // F(1)
        int fib = 1; // Placeholder for Fibonacci value

        for (int i = 2; i <= n; i++) {
            fib = a + b; // Current Fibonacci number
            a = b;       // Move F(i-1) to F(i-2)
            b = fib;     // Move current Fibonacci to F(i-1)
        }
        return fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Fibonacci position (e.g., FIB(7)): ");
        String input = scanner.nextLine();

        if (input.startsWith("FIB")) {
            String numberPart = input.substring(input.indexOf('(') + 1, input.indexOf(')'));
            int n = Integer.parseInt(numberPart.trim());
            System.out.println("Fibonacci Number at position " + n + ": " + iterativeFibonacci(n));
        } else {
            System.out.println("Invalid command. Please use the format FIB(N).");
        }
    }
}

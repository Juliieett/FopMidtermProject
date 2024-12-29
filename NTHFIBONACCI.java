import java.util.HashMap;
import java.util.Map;

public class NTHFIBONACCI {
    private final Map<String, Integer> variables = new HashMap<>();

    public void eval(String code) {
        String[] lines = code.split(";");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.contains("=")) {
                handleAssignment(line);
            } else if (line.startsWith("PRINT")) {
                handlePrint(line);
            }
        }
    }

    private void handleAssignment(String line) {
        String[] parts = line.split("=");
        String varName = parts[0].trim();
        String expression = parts[1].trim();

        if (expression.startsWith("NTHFIBONACCI(") && expression.endsWith(")")) {
            int n = Integer.parseInt(expression.substring(expression.indexOf('(') + 1, expression.indexOf(')')).trim());
            int result = iterativeFibonacci(n);
            variables.put(varName, result);
        }
    }

    private void handlePrint(String line) {
        String varName = line.substring(line.indexOf('(') + 1, line.indexOf(')')).trim();
        System.out.println(variables.get(varName));
    }

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
        NTHFIBONACCI interpreter = new NTHFIBONACCI();

        String program = """
            fibValue = NTHFIBONACCI(7);
            PRINT(fibValue);
        """;

        interpreter.eval(program);
    }
}

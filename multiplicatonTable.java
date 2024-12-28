import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class multiplicationTable {
    private final Map<String, Integer> variables = new HashMap<>(); // Variable storage

    public void eval(String code) {
        String[] lines = code.split(";"); // Split by statement terminator
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // Handle variable assignment
            if (line.contains("=")) {
                handleAssignment(line);
            }
            // Handle print statements
            else if (line.startsWith("PRINT")) {
                handlePrint(line);
            }
            // Handle multiplication table
            else if (line.startsWith("MULTIPLICATIONTABLE")) {
                handleMultiplicationTable(line);
            }
        }
    }

    private void handleAssignment(String line) {
        String[] parts = line.split("=");
        String varName = parts[0].trim();
        String expression = parts[1].trim();
        String[] numbers = expression.split("\\+");
        int value = Integer.parseInt(numbers[0].trim()) + Integer.parseInt(numbers[1].trim());
        variables.put(varName, value);
    }

    private void handlePrint(String line) {
        String varName = line.substring(line.indexOf('(') + 1, line.indexOf(')')).trim();
        if (variables.containsKey(varName)) {
            System.out.println(variables.get(varName));
        } else {
            System.out.println("Variable not found: " + varName);
        }
    }

    private void handleMultiplicationTable(String line) {
        String[] parts = line.split("\\(");
        int num = Integer.parseInt(parts[1].replace(")", "").trim()); // Extract the number for the multiplication table
        System.out.println("Multiplication Table for " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }

    public static void main(String[] args) {
        multiplicationTable interpreter = new multiplicationTable();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your BASIC-like code (end with an empty line):");
        StringBuilder code = new StringBuilder();

        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            code.append(line).append(";");
        }

        System.out.println("\nExecuting code...");
        interpreter.eval(code.toString());
    }
}

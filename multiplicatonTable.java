import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultiplicationTable {
    private final Map<String, Integer> variables = new HashMap<>(); // Variable storage

    public void eval(String code) {
        String[] lines = code.split(";"); // Split by statement terminator
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // Handle INPUT command
            if (line.startsWith("INPUT")) {
                handleInput(line);
            }
            // Handle PRINT command
            else if (line.startsWith("PRINT")) {
                handlePrint(line);
            }
            // Handle FOR-NEXT loop for multiplication table
            else if (line.startsWith("FOR")) {
                handleForLoop(line);
            }
        }
    }

    private void handleInput(String line) {
        String varName = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\"")).trim();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number for " + varName + ": ");
        int value = scanner.nextInt();
        variables.put(varName, value);
    }

    private void handlePrint(String line) {
        String varName = line.substring(line.indexOf("(") + 1, line.indexOf(")")).trim();
        if (variables.containsKey(varName)) {
            System.out.println(variables.get(varName));
        } else {
            System.out.println("Variable not found: " + varName);
        }
    }

    private void handleForLoop(String line) {
        // Parse the FOR loop to get start, end, and loop variable
        String loopVar = line.substring(line.indexOf(" ") + 1, line.indexOf(" =")).trim();
        int start = Integer.parseInt(line.substring(line.indexOf("=") + 1, line.indexOf("TO")).trim());
        int end = Integer.parseInt(line.substring(line.indexOf("TO") + 2).trim());

        System.out.println("Multiplication Table for " + start + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(start + " * " + i + " = " + (start * i));
        }
    }

    public static void main(String[] args) {
        MultiplicationTable interpreter = new MultiplicationTable();
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

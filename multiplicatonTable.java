import java.util.*;

public class MultiplicationTable {
    private final Map<String, Integer> variables = new HashMap<>(); // Variable storage

    // Method to evaluate the given BASIC-like code
    public void eval(String code) {
        String[] lines = code.split("\n");
        int currentLine = 0;

        // Iterate through each line of code
        while (currentLine < lines.length) {
            String line = lines[currentLine].trim();

            if (line.isEmpty()) {
                currentLine++;
                continue;
            }

            // Handle LET command
            if (line.startsWith("LET")) {
                handleAssignment(line);
            }
            // Handle PRINT command
            else if (line.startsWith("PRINT")) {
                handlePrint(line);
            }
            // Handle FOR-NEXT loop for multiplication table
            else if (line.startsWith("FOR")) {
                handleForLoop(line);
            }
            // Handle INPUT command
            else if (line.startsWith("INPUT")) {
                handleInput(line);
            }

            currentLine++;
        }
    }

    // Handle LET command (e.g., LET X = 5)
    private void handleAssignment(String line) {
        String[] parts = line.split("=");
        String varName = parts[0].replace("LET", "").trim();
        int value = Integer.parseInt(parts[1].trim());

        variables.put(varName, value);
    }

    // Handle PRINT command (e.g., PRINT X or PRINT expression)
    private void handlePrint(String line) {
        String content = line.replace("PRINT", "").trim();

        // Check if the content contains a variable or expression
        if (content.contains("\"")) {
            // Handle expression with string concatenation
            String[] parts = content.split("\\+");
            StringBuilder expression = new StringBuilder();

            for (String part : parts) {
                part = part.trim();
                if (part.startsWith("\"")) {
                    // Handle string literals
                    expression.append(part.replace("\"", ""));
                } else if (variables.containsKey(part)) {
                    // Handle variables
                    expression.append(variables.get(part));
                }
            }
            System.out.println(expression.toString()); // Print the evaluated expression
        } else {
            // Directly print the variable if it's found
            if (variables.containsKey(content)) {
                System.out.println(variables.get(content));
            } else {
                System.out.println("Variable not found: " + content);
            }
        }
    }

    // Handle FOR-NEXT loop (e.g., FOR I = 1 TO 10)
    private void handleForLoop(String line) {
        // Parse the FOR loop to get the start, end, and loop variable
        String loopVar = line.substring(line.indexOf(" ") + 1, line.indexOf(" =")).trim();
        int start = Integer.parseInt(line.substring(line.indexOf("=") + 1, line.indexOf("TO")).trim());
        int end = Integer.parseInt(line.substring(line.indexOf("TO") + 2).trim());

        // Loop from start to end (inclusive)
        for (int i = start; i <= end; i++) {
            // Store the loop variable (I) in the variables map
            variables.put(loopVar, i);

            // Print the multiplication of X and the loop variable (I)
            if (variables.containsKey("X")) {
                int x = variables.get("X");
                System.out.println(x + " * " + i + " = " + (x * i)); // Multiplication result
            }
        }
    }

    // Handle INPUT command (e.g., INPUT "NUMBER")
    private void handleInput(String line) {
        // Extract the prompt message inside quotes
        String prompt = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\"")).trim();
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt + ": ");
        int value = scanner.nextInt();

        // Store the input value in the variables map
        String varName = prompt.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        variables.put(varName, value);
    }

    // Main method for executing the code
    public static void main(String[] args) {
        MultiplicationTable interpreter = new MultiplicationTable();
        Scanner scanner = new Scanner(System.in);

        // Allow the user to input BASIC-like code
        System.out.println("Enter your BASIC-like code (end with an empty line):");
        StringBuilder code = new StringBuilder();

        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            code.append(line).append("\n");
        }

        // Execute the code after user input
        System.out.println("\nExecuting code...");
        interpreter.eval(code.toString());
    }
}
//INPUT "Enter a number"
//LET X = 5
//PRINT X
//FOR I = 1 TO 10
//    PRINT "Multiplication of " + X + " and " + I

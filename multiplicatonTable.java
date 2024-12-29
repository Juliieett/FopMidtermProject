import java.util.*;

public class MultiplicationTable {
    private final Map<String, Integer> variables = new HashMap<>();

    
    public void eval(String code) {
        String[] lines = code.split("\n");
        int currentLine = 0;


        while (currentLine < lines.length) {
            String line = lines[currentLine].trim();

            if (line.isEmpty()) {
                currentLine++;
                continue;
            }

            // Handle LET command (Variable assignment)
            if (line.startsWith("LET")) {
                handleAssignment(line);
            }
            // Handle PRINT command (Display output)
            else if (line.startsWith("PRINT")) {
                handlePrint(line);
            }
            // Handle FOR-NEXT loop (Iterate for multiplication table)
            else if (line.startsWith("FOR")) {
                currentLine = handleForLoop(lines, currentLine);
            }

            currentLine++;
        }
    }

    // Handle LET command for variable assignment
    private void handleAssignment(String line) {
        String[] parts = line.split("=");
        String varName = parts[0].replace("LET", "").trim();
        int value = Integer.parseInt(parts[1].trim());
        variables.put(varName, value);
    }

    // Handle PRINT command for displaying output
    private void handlePrint(String line) {
        String content = line.replace("PRINT", "").trim();

        if (content.contains("\"")) {
            // Handle string with variables or expressions
            String[] parts = content.split("\\+");
            StringBuilder result = new StringBuilder();

            for (String part : parts) {
                part = part.trim();
                if (part.startsWith("\"")) {
                    result.append(part.replace("\"", ""));
                } else if (variables.containsKey(part)) {
                    result.append(variables.get(part));
                } else {
                    result.append(part); // Append raw content if not a variable
                }
            }
            System.out.println(result.toString()); // Output the evaluated expression
        } else {
            // Print the value of a variable directly
            if (variables.containsKey(content)) {
                System.out.println(variables.get(content));
            } else {
                System.out.println("Error: Variable not found: " + content);
            }
        }
    }

    // Handle FOR-NEXT loop to iterate and process multiplication
    private int handleForLoop(String[] lines, int startLine) {
        String line = lines[startLine];
        String loopVar = line.substring(line.indexOf(" ") + 1, line.indexOf(" =")).trim();
        int start = Integer.parseInt(line.substring(line.indexOf("=") + 1, line.indexOf("TO")).trim());
        int end = Integer.parseInt(line.substring(line.indexOf("TO") + 2).trim());

        int currentLine = startLine + 1;
        List<String> loopBody = new ArrayList<>();

        // Collect all lines within the FOR-NEXT block
        while (currentLine < lines.length && !lines[currentLine].trim().equals("NEXT")) {
            loopBody.add(lines[currentLine].trim());
            currentLine++;
        }

        // Loop from start to end
        for (int i = start; i <= end; i++) {
            variables.put(loopVar, i); // Update loop variable
            for (String bodyLine : loopBody) {
                eval(bodyLine); // Execute body of the loop
            }
        }

        return currentLine; // Return next line to process after NEXT
    }

    public static void main(String[] args) {
        MultiplicationTable interpreter = new MultiplicationTable();

        // Sample code input
        String code = """
            LET X = 5
            PRINT "Value of X is: " + X
            FOR I = 1 TO 10
                PRINT X + " * " + I + " = " + (X * I)
            NEXT
        """;

        System.out.println("\nExecuting code...");
        interpreter.eval(code);
    }
}

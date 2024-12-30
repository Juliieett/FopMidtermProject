import java.util.*;
import java.util.regex.*;

public class SimpleInterpreter{
  private final Map<String, Integer> variables = new Hashmap<>();

public void eval(String code) {
        String[] lines = code.split("\n");
        int currentLine = 0;

        while (currentLine < lines.length) {
            String line = lines[currentLine].trim();

            if (line.isEmpty()) {
                currentLine++;
                continue;
            }
            if (line.startsWith("LET")) {
                handleAssignment(line);
            } else if (line.startsWith("PRINT")) {
                handlePrint(line);
            } else if (line.startsWith("FOR")) {
                currentLine = handleForLoop(lines, currentLine);
            } else if (line.startsWith("WHILE")) {
                currentLine = handleWhileLoop(lines, currentLine);
            } else if (line.startsWith("IF")) {
                currentLine = handleIfStatement(lines, currentLine);

            } else if (line.startsWith("NEXT") || line.startsWith("WEND") || line.startsWith("END IF")) {

            }else if (line.startsWith("PALINDROME")) {
                handlePalindrome(line);
            }else {
                System.out.println("Syntax error at line: " + (currentLine + 1));
            }

            currentLine++;
        }
    }


  
}

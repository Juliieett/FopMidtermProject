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
  private void handleAssignment(String line) {
        try {
            String[] parts = line.split("=", 2);
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid assignment syntax: " + line);
            }
            String varName = parts[0].replace("LET", "").trim();
            String expression = parts[1].trim();
            int value = evaluateExpression(expression);
            variables.put(varName, value);
        } catch (Exception e) {
            System.out.println("Error in assignment: " + line + " - " + e.getMessage());
        }
    }
 private int evaluateExpression(String expression) {
        try {
            Deque<Integer> values = new ArrayDeque<>();
            Deque<Character> operators = new ArrayDeque<>();

            // Tokenize the expression by operators, parentheses, and numbers
            StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/()%()", true);
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken().trim();

                if (token.isEmpty()) continue;

                // token=numbers?
                if (isNumeric(token)) {
                    values.push(Integer.parseInt(token));
                }
                // token=variables? also gets its value
                else if (variables.containsKey(token)) {
                    values.push(variables.get(token));
                }
                // Handle operators
                else if (token.matches("[+\\-*/%]")) {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token.charAt(0))) {
                        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.push(token.charAt(0));
                }
                // Handle parentheses
                else if (token.equals("(")) {
                    operators.push('(');
                } else if (token.equals(")")) {
                    while (operators.peek() != '(') {
                        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.pop(); // Remove '('
                } else {
                    throw new IllegalArgumentException("Unknown token: " + token);
                }
            }

            // Apply remaining operators
            while (!operators.isEmpty()) {
                values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
            }

            return values.pop();
        } catch (Exception e) {
            System.out.println("Error evaluating expression: " + expression + " - " + e.getMessage());
            return 0;
        }
    }

private int applyOperator(char operator, int b, int a) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b != 0 ? a / b : 0; // Avoid division by zero
            case '%': return a % b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private int precedence(char operator) {
        return (operator == '+' || operator == '-') ? 1 : 2; // * and / have higher precedence
    }

    private void handlePrint(String line) {
        String expression = line.replace("PRINT", "").trim();
        if (variables.containsKey(expression)) {
            System.out.println(variables.get(expression));
        } else if (expression.startsWith("\"") && expression.endsWith("\"")) {
            System.out.println(expression.substring(1, expression.length() - 1)); 
        } else {
            System.out.println("Undefined variable: " + expression);
        }
    }

    private int handleForLoop(String[] lines, int currentLine) {
        try {
            String line = lines[currentLine].trim();
            Matcher matcher = Pattern.compile("FOR\\s+(\\w+)\\s*=\\s*(.+)\\s+TO\\s+(.+)").matcher(line);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid FOR syntax: " + line);
            }

            String varName = matcher.group(1);
          String startExpr = matcher.group(2).trim();
         String endExpr = matcher.group(3).trim();

            int start = evaluateExpression(startExpr);
            int end = evaluateExpression(endExpr);
            variables.put(varName, start);

            int loopStartLine = currentLine + 1;
            List<String> loopBody = new ArrayList<>();

            int i = loopStartLine;
            while (i < lines.length && !lines[i].trim().startsWith("NEXT")) {
                loopBody.add(lines[i].trim());
                i++;
            }
            if (i == lines.length || !lines[i].trim().equals("NEXT")) {
                throw new IllegalArgumentException("Missing NEXT for FOR loop starting at line: " + currentLine);
            }

            while (variables.get(varName) <= end) {
                for (String loopLine : loopBody) {
                    evalLine(loopLine);
                }
                variables.put(varName, variables.get(varName) + 1);
            }

            return i;
        } catch (Exception e) {
            System.out.println("Error in FOR loop: " + e.getMessage());
            return currentLine;
        }
    }
 private int handleWhileLoop(String[] lines, int currentLine) {
        try {
            String line = lines[currentLine].trim();
            String condition = line.replace("WHILE", "").trim();
            int startLine = currentLine + 1;

            List<String> loopBody = new ArrayList<>();
            int i = startLine;
            while (i < lines.length && !lines[i].trim().equals("WEND")) {
                loopBody.add(lines[i].trim());
                i++;
            }
            if (i == lines.length) {
                throw new IllegalArgumentException("Missing WEND for WHILE loop starting at line: " + currentLine);
            }

            while (evaluateCondition(condition)) {
                for (String loopLine : loopBody) {
                    evalLine(loopLine);
                }
            }

            return i;
        } catch (Exception e) {
            System.out.println("Error in WHILE loop: " + e.getMessage());
            return currentLine;
        }
    }
private int handleIfStatement(String[] lines, int currentLine) {
        try {
            String line = lines[currentLine].trim();
            String condition = line.replace("IF", "").replace("THEN", "").trim();

            boolean conditionResult = evaluateCondition(condition);
            int i = currentLine + 1;

            List<String> ifBody = new ArrayList<>();
            List<String> elseBody = new ArrayList<>();
            boolean inElse = false;

            while (i < lines.length && !lines[i].trim().equals("END IF")) {
                String codeLine = lines[i].trim();
              
                if (codeLine.startsWith("ELSE")) {
                    inElse = true;
                    i++;
                    continue;
                }
               if (inElse) {
                    elseBody.add(codeLine);
                } else {
                  ifBody.add(codeLine);
                }

                i++;
            }
            if (conditionResult) {
                for (String lineInBody : ifBody) {
                    evalLine(lineInBody);
                }
            } else {
                for (String lineInBody : elseBody) {
                    evalLine(lineInBody);
                }
            }
            return i;
        } catch (Exception e) {
            System.out.println("Error in IF-ELSE statement: " + e.getMessage());
            return currentLine;
        }
    }



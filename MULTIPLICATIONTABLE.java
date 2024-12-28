import java.util.Scanner;

public class MULTIPLICATIONTABLE {

    public static void printMultiplicationTable(int num) {
        System.out.println("Multiplication Table for " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number for the multiplication table (e.g., MULTIPLICATIONTABLE(5)): ");
        String input = scanner.nextLine();

        if (input.startsWith("MULTIPLICATIONTABLE")) {
            String numberPart = input.substring(input.indexOf('(') + 1, input.indexOf(')'));
            int num = Integer.parseInt(numberPart.trim());
            printMultiplicationTable(num);
        } else {
            System.out.println("Invalid command. Please use the format MULTIPLICATIONTABLE(N).");
        }
    }
}


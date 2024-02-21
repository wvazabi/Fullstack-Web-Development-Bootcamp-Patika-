import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1, num2;
        String operation = "";

        // Ask the user to enter an operation
        System.out.println("Please enter an operation (*, -, /, +): ");

        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Read the operation from the user
        operation = input.nextLine();

        // Ask the user to enter numbers
        System.out.println("Please enter NUMBERS");

        // Read the numbers from the user
        num1 = input.nextInt();
        num2 = input.nextInt();

        // Perform the operation based on the user input
        switch (operation) {
            case "*":
                System.out.println("Result: " + (num1 * num2));
                break;
            case "-":
                System.out.println("Result: " + (num1 - num2));
                break;
            case "/":
                // Check if the second number is not zero to avoid division by zero error
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
            case "+":
                System.out.println("Result: " + (num1 + num2));
                break;
            default:
                System.out.println("Invalid operation");
        }
    }
}

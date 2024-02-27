import java.util.Scanner;

public class Main {
    //Recursive method to print the pattern
    public static void pattern(int number) {
        // Base case: if number is less than or equal to 0, print it and return
        if (number <= 0) {
            System.out.print(number + " ");
        } else {
            // Print the current number
            System.out.print(number + " ");

            // Recursive call: reduce the number by 5 and call the pattern method again
            System.out.println("test");
            pattern(number - 5);

            // Print the current number again after the recursive call
            System.out.print(number + " ");


        }
    }

    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        // Read the number entered by the user
        int number = sc.nextInt();

        // Call the pattern method with the user input number
        pattern(number);
    }
}

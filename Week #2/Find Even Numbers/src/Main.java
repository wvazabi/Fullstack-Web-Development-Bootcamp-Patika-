import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declare variables
        int x, count3 = 0, sum3 = 0;
        double average;

        // Prompt the user to enter a number
        System.out.println("Please Enter a Number");

        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Read the input number from the user
        x = input.nextInt();

        // Iterate from 1 up to x - 1
        for (int i = 1; i < x; i++) {
            // Check if i is divisible by both 3 and 4
            if (i % 3 == 0 && i % 4 == 0) {
                // Add i to the sum and increment the count
                sum3 += i;
                count3++;
            }
        }

        // Calculate the average of numbers divisible by both 3 and 4
        average = (double) sum3 / count3;

        // Print the result
        System.out.println("Result: " + average);

    }
}

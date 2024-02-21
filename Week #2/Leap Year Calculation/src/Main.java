import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Year: "); // Prompt the user to enter a year
        int year = scanner.nextInt();

        // Check if the year is a leap year according to the specified rules
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a leap year!"); // If it is a leap year, print this message
        } else {
            System.out.println(year + " is not a leap year!"); // If it is not a leap year, print this message
        }
        scanner.close();
    }
}

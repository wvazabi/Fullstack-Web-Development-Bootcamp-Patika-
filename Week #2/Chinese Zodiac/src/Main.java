import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for their birth year
        System.out.print("Enter your Birth Year: ");
        int year = scanner.nextInt();

        // Determine the Chinese Zodiac sign based on the birth year
        String[] signs = {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"};
        String sign = signs[year % 12];

        // Print out the Chinese Zodiac sign
        System.out.println("Your Chinese Zodiac Sign: " + sign);

        scanner.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Variables are defined
        int math, turkish, physics, music, history, chemistry;
        String status = "";

        //Scanner class is defined
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Math value (between 0 and 100):");
        math = input.nextInt();

// Check if the input value for Math is within the range of 0 to 100
        while (math < 0 || math > 100) {
            System.out.println("Invalid input! Please enter Math value between 0 and 100:");
            math = input.nextInt();
        }

        System.out.println("Please enter Turkish value (between 0 and 100):");
        turkish = input.nextInt();

// Check if the input value for Turkish is within the range of 0 to 100
        while (turkish < 0 || turkish > 100) {
            System.out.println("Invalid input! Please enter Turkish value between 0 and 100:");
            turkish = input.nextInt();
        }

        System.out.println("Please enter Physics value (between 0 and 100):");
        physics = input.nextInt();

// Check if the input value for Physics is within the range of 0 to 100
        while (physics < 0 || physics > 100) {
            System.out.println("Invalid input! Please enter Physics value between 0 and 100:");
            physics = input.nextInt();
        }

        System.out.println("Please enter Music value (between 0 and 100):");
        music = input.nextInt();

// Check if the input value for Music is within the range of 0 to 100
        while (music < 0 || music > 100) {
            System.out.println("Invalid input! Please enter Music value between 0 and 100:");
            music = input.nextInt();
        }

        System.out.println("Please enter History value (between 0 and 100):");
        history = input.nextInt();

// Check if the input value for History is within the range of 0 to 100
        while (history < 0 || history > 100) {
            System.out.println("Invalid input! Please enter History value between 0 and 100:");
            history = input.nextInt();
        }

        System.out.println("Please enter Chemistry value (between 0 and 100):");
        chemistry = input.nextInt();

// Check if the input value for Chemistry is within the range of 0 to 100
        while (chemistry < 0 || chemistry > 100) {
            System.out.println("Invalid input! Please enter Chemistry value between 0 and 100:");
            chemistry = input.nextInt();
        }


        //Calculation result

        int sum = (turkish + music + history + chemistry + math + physics);
        double result  = (sum / 6.0);

        // The average grade is displayed with two decimal precision.
        String formattedResult = String.format("%.2f", result);

        status = (result >= 60) ? "Pass" : "Fail";

        System.out.println("Average of Grades is " + formattedResult + " status: " + status);
    }
}
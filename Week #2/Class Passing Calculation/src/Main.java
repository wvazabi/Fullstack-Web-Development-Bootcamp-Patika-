import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declare arrays to store lesson names and grades
        String[] lessons = {"Turkish", "Math", "Music", "Chemistry", "Physics"};
        int[] grade = {0, 0, 0, 0, 0};
        double sumGrade = 0;
        double result;
        int temp;

        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter grades
        System.out.println("Please Enter Your Grades");

        // Loop through each lesson to get the grades
        for (int i = 0; i < lessons.length; i++) {
            System.out.println("Enter the grade for " + lessons[i] + ": ");
            temp = input.nextInt();

            // Validate the grade
            while (!(temp > 0 && temp <= 100)) {
                System.out.println("Enter a valid grade between 0 - 100\n");
                System.out.println("Enter the grade for " + lessons[i] + ": ");
                temp = input.nextInt();
            }

            // If the grade is valid, store it and update the sumGrade
            if (temp > 0 && temp <= 100) {
                grade[i] = temp;
                sumGrade += temp;
            }
        }

        // Calculate the average grade
        result = sumGrade / 5;

        // Display the average grade
        System.out.println("Average grade = " + result);

        // Check if the student passed or failed
        if(result > 55) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}

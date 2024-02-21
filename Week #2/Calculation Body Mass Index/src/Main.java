import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int height, weight;
        double BMI;

        System.out.println("Please enter your height (in meters): \n" +
                "Please enter your weight: \n");

        Scanner input = new Scanner(System.in);

        height = input.nextInt();
        weight = input.nextInt();

        BMI =  weight/(Math.pow(height,2));

        String fBMI = String.format("%.2f",BMI);

        System.out.println("Body Mass Index: " + BMI);






    }
}
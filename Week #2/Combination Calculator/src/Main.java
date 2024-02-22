import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1 = 0, num2 = 0,num3 = 0, factorial = 1, factorial2 = 1, factorial3 = 1;
        double total;

        System.out.println("Please Enter a number");

        Scanner input = new Scanner(System.in);

        num1 = input.nextInt();

        System.out.println("Please Enter a number");
        num2 = input.nextInt();

        for (int i = 1; i <= num1; i++) {
            factorial *= i;
        }

        for (int i = 1; i <= num2; i++) {
            factorial2 *= i;
        }

        num3 = num1 - num2;

        for (int i = 1; i <= num3; i++) {
            factorial3 *= i;
        }

        total = factorial / (factorial2 * factorial3);

        System.out.println(total);




    }
}
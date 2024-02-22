import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1 = 0;

        System.out.println("Please Enter a number");

        Scanner input = new Scanner(System.in);

        num1 = 5;

        for (int i = 1; i <= num1; i++) {

            for (int j = 1; j <= (num1 - i); j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= (2 * i) - 1; k++) {
                System.out.print("*");
            }

            System.out.println();

        }

        int num2 = 4;

        for (int i = num2; i >= 1; i--) {

          for (int j = 0; j < (num1 - i); j++) {
                 System.out.print(" ");
            }

            for(int k = 1; k <= ((2 * i) -1); k++) {
                System.out.print("*");
            }
            System.out.println();

        }


    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1 = 0;

        System.out.println("Please Enter a number");

        Scanner input = new Scanner(System.in);

        num1 = input.nextInt();
        double total = 0;

        for (double i = 1; i <= num1; i++) {
            total += (1/i);
        }

        System.out.println(total);


    }
}

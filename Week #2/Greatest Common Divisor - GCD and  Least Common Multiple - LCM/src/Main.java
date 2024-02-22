import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;


        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter a small number: ");
        num1 = input.nextInt();
        System.out.print("Please Enter a bigger number: ");
        num2 = input.nextInt();

        int gcd = 1;
        int lcm = 1;

        // GCD

        for (int i = 2; i <= num1; i++) {
            if ((num1 % i == 0) && (num2 % i == 0)) {
                gcd = i;
            }
        }

        for (int i = 1; i <= num1 * num2; i++) {
            if(i % num1 == 0 && i % num2 == 0) {
                lcm = i;
                break;
            }
        }

        System.out.println("GCD " + gcd + " LCM " + lcm);
    }
}

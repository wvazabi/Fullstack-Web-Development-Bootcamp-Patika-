import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1 = 0, total = 0;

        System.out.println("Please Enter a number");

        Scanner input = new Scanner(System.in);

        num1 = input.nextInt();

        while (num1 != 0) {
            total += (num1 % 10);
            System.out.println(num1 % 10);
            num1 /= 10;
        }

        System.out.println(total);


    }
}

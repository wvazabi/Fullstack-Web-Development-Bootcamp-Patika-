import java.util.Scanner;

public class Main {
    static int methods(int num) {
        int temp = num;

        System.out.print(num);
        System.out.print(" ");
        while (!(temp <= 0)) {
            temp -= 5;
            System.out.print(temp);
            System.out.print(" ");
        }

        while (temp != num) {
            temp += 5;
            System.out.print(temp);
            System.out.print(" ");
        }
            return 1;
    }

    public static void main(String[] args) {

        int num1 = 0;

        System.out.println("Please Enter a number");

        Scanner input = new Scanner(System.in);

        num1 = input.nextInt();

        int x = methods(num1);

    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1;
        int num2;
        int total = 1;

        System.out.println("Please Enter a number");

        Scanner input = new Scanner(System.in);

        num1 = input.nextInt();

        System.out.println("Please Enter a number");
        num2 = input.nextInt();


        for (int i = 0; i < num2; i++) {
            total *= num1;
        }

        System.out.println(total);


    }
}

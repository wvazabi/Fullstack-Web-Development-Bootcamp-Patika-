import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1, total = 0;

        Scanner input = new Scanner(System.in);

        do {

            System.out.println("Please Enter a Numnber");
            num1 = input.nextInt();

            if (num1 % 4 == 0) {
                total += num1;
            }

        } while (num1 % 2 != 1);

        System.out.println(total);

    }
}
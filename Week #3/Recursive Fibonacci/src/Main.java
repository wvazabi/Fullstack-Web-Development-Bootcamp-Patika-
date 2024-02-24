import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1 = 0;

        Scanner input = new Scanner(System.in);

        // Test amaçlı  döngüye sokuldu
        while (num1 != 404) {
            System.out.println("Please Enter a number");
            num1 = input.nextInt();


            int x = fibo(num1);

            System.out.println(x);
        }


    }

    public static int fibo(int num1) {

        if (num1 == 0) {
            return 0;
        } else if (num1 == 1) {
            return 1;
        } else {
            return fibo(num1 - 2) + fibo(num1 - 1);
        }
    }

}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int count   = 0,
            temp    = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        System.out.println("How many numbers do you wanna add");

        Scanner input = new Scanner(System.in);

        count = input.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.println(i + ". sayıyı giriniz: ");
            temp = input.nextInt();

            if (temp > max) max = temp;
            if (temp < min) min = temp;

        }

        System.out.println("max: " + max + " min: " + min);
    }
}
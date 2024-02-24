import java.util.Scanner;

public class Main {

    static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Taban değeri giriniz: ");
            int base = scanner.nextInt();
            System.out.print("Üs değerini giriniz: ");
            int exponent = scanner.nextInt();

            int result = power(base, exponent);
            System.out.println("Sonuç: " + result);
        }
    }
}


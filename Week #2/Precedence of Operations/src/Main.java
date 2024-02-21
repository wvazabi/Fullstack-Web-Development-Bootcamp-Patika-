import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan 3 sayıyı al
        System.out.print("Enter the first number (a): ");
        int a = scanner.nextInt();

        System.out.print("Enter the second number (b): ");
        int b = scanner.nextInt();

        System.out.print("Enter the third number (c): ");
        int c = scanner.nextInt();

        // İşlemi gerçekleştir ve sonucu ekrana yazdır
        int result = a + b * c - b;
        System.out.println("Result: " + result);

    }
}
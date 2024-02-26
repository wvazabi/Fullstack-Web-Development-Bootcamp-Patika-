import java.util.Scanner;

public class Main {

    static boolean isPrime(int number, int divisor) {
        // Eğer bölen sayı 1'e eşitse, asal sayıdır.
        if (divisor == 1) {
            return true;
        } else {
            // Eğer bölen sayı 1'e eşit değilse ve number'a bölünüyorsa, asal değildir.
            if (number % divisor == 0) {
                return false;
            } else {
                // Aksi durumda, sayıyı bir önceki bölenle kontrol et.
                return isPrime(number, divisor - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı Giriniz: ");
        int number = scanner.nextInt();

        if (number <= 1) {
            System.out.println(number + " sayısı ASAL değildir !");
        } else {
            // Sayının asal olup olmadığını kontrol ederken, 2'den (sayının yarısına kadar olan) bölenlerin kontrolü yeterlidir.
            boolean isPrime = isPrime(number, number / 2);
            if (isPrime) {
                System.out.println(number + " sayısı ASALDIR !");
            } else {
                System.out.println(number + " sayısı ASAL değildir !");
            }
        }
    }
}

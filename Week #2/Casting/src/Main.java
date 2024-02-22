import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // String ifadeyi tam sayıya dönüştürme
        System.out.print("Bir tam sayı girin: ");
        String strTamSayi = input.nextLine();
        int tamSayi = Integer.parseInt(strTamSayi);

        // Tam sayıyı double'a dönüştürme
        System.out.print("Bir double sayı girin: ");
        double doubleSayi = input.nextDouble();
        int tamSayiFromDouble = (int) doubleSayi; // Double sayıyı tam sayıya dönüştürmek

        // Sonuçları ekrana yazdır
        System.out.println("String ifadeyi tam sayıya dönüştürme: " + tamSayi);
        System.out.println("Tam sayıyı double'a dönüştürme: " + doubleSayi);
        System.out.println("Double sayıyı tam sayıya dönüştürme: " + tamSayiFromDouble);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Sayı giriniz:");
        int num = input.nextInt();

        int[] arr = {15, 12, 788, 1, -1, -778, 2, 0};
        int closestSmaller = Integer.MIN_VALUE; // Girilen sayıdan küçük en yakın sayı
        int closestLarger = Integer.MAX_VALUE; // Girilen sayıdan büyük en yakın sayı

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num && arr[i] > closestSmaller) {
                closestSmaller = arr[i];
            }
            if (arr[i] > num && arr[i] < closestLarger) {
                closestLarger = arr[i];
            }
        }

        System.out.println("Girilen sayıdan küçük en yakın sayı: " + closestSmaller);
        System.out.println("Girilen sayıdan büyük en yakın sayı: " + closestLarger);
    }
}

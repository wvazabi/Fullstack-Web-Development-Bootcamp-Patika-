import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of Array");

        int arraySize = input.nextInt();
        int[] arr = new int[arraySize];
        for (int i = 1; i <= arraySize; i++) {
            System.out.println( i +". Elemanı Girniz:");
            arr[i-1] = input.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Sıralama " + Arrays.toString(arr));



    }
}
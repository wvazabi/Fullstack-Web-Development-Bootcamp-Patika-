import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1;
        System.out.println("Enter a number");
        Scanner input = new Scanner(System.in);

        num1 = input.nextInt();

        for (int i = 1; i <= num1; i *= 4){
            System.out.println("Powers of 4: " + i);
        }
        System.out.println("-----------------------");

        for (int i = 1; i <= num1; i *= 5){
            System.out.println("Powers of 5: " + i);
        }
    }
}
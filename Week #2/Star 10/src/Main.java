import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num1 = 11;


        for (int i = 0; i < num1; i ++) {
            for(int j = 1; j < num1 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}

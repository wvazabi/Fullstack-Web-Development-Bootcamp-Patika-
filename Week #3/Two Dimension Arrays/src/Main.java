import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Matris boyutunu sizin belirlediğiniz matris değerlerini ise kullanıcının girdiği bir algoritma yazınız.

      Scanner input = new Scanner(System.in);
//
//        System.out.println("Enter row value");
//
//        int row = input.nextInt();
//        System.out.println("Enter column value");
//        int col = input.nextInt();
//

        int [][] matris = new int[3][3];

        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                //System.out.println("Enter the value");
                //int x = input.nextInt();
                matris[i][j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < matris.length; i++) {
            System.out.println();
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j] + " ");
            }
        }





    }
}
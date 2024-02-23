import java.util.Scanner;

//123
public class Main {
    static boolean isPalindrom(int num) {
        int temp;
        int revNumber = 0;

        temp = num;

        while (temp != 0) {

            revNumber = 10 * revNumber + temp % 10;

            temp = temp / 10;

        }

        if (revNumber == num) {
            return true;
        } else {
            return false;
        }


    }

    public static void main(String[] args) {

        int number;
        System.out.println("Enter a number");
        Scanner input = new Scanner(System.in);

        number = input.nextInt();


        if (isPalindrom(number)) {
            System.out.println(number + " is a Palindrom Number");
        } else {
            System.out.println(number + " is NOT a Palindrom Number");

        }
    }
}
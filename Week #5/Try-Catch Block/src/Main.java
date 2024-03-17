import java.util.Scanner;

public class Main {
    public static int printIndex(int[] intArr, String input) {

        try {
            int num = Integer.parseInt(input);
            return intArr[num];

        } catch (ArrayIndexOutOfBoundsException e) {

            throw new IllegalArgumentException("Invalid index. Index must be within the array bounds.");

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Please enter a valid number");
        }

    }

    public static void main(String[] args) {

        int[] age = new int[10];

        for (int i = 0; i < age.length; i++) {
            age[i] = i * 10;
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter requested Index: ");
        String requestedIndex = input.nextLine();

        try{

            System.out.println(printIndex(age,requestedIndex));

        } catch (IllegalArgumentException e){

            System.out.println(e.getMessage());

        }

    }
}
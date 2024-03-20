import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static  void TimeConvert(int num) {
        int hour = num / 60;
        int minute = num % 60;

        System.out.println(hour + ":" + minute);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter valid num");
        TimeConvert(input.nextInt());



    }
}
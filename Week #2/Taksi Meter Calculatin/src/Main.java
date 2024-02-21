import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int km;
        final double fareKM = 2.2;
        double totalFare = 10;

        System.out.println("How far is your destination in kilometers");

        //Scanner class is defined
        Scanner input = new Scanner(System.in);

        // The distance in kilometers obtained from user.
        km = input.nextInt();

        //Fare calculation
        totalFare = (km * fareKM < 10) ? 20 : (km * fareKM +10);

        //Total taxi meter calculation
        System.out.println("TAXI fee " + totalFare);












    }
}
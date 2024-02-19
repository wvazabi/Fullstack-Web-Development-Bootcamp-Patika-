import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the lengths of non-hypotenuse sides of triangle");

        double side1, side2, hypo;


        //Scanner class is created
        Scanner input = new Scanner(System.in);
        side1 = input.nextDouble();
        side2 = input.nextDouble();

        hypo = Math.sqrt(Math.pow(side1,2) + Math.pow(side2,2));

        System.out.println("Hypotenuse = " + hypo);



    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int side1, side2, side3, perimeter, temp;
        double area;

        System.out.println("Enter the 3 sides of The Triangle");


        //Create Scanner Class
        Scanner input = new Scanner(System.in);

        side1 = input.nextInt();
        side2 = input.nextInt();
        side3 = input.nextInt();

        perimeter = (side1 + side2 + side3);
        temp = (perimeter / 2);
        area = Math.sqrt(temp * (temp - side1) * (temp - side2) * (temp - side3));

        String formattedArea = String.format("%.2f",area);


        System.out.println("The area of the triangle is " + formattedArea);



    }


}
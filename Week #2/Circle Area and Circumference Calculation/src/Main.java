import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final float PI = 3.14F;
        int radius,centralAngle;
        double area,areaSeg, circumference;

        System.out.println("Enter radios of circle and central angle");

        Scanner input = new Scanner(System.in);
        radius = input.nextInt();
        centralAngle = input.nextInt();

        //Circle area calculation
        area = PI * Math.pow(radius,2);

        //Circumference
        circumference = 2 * PI * radius;

        //Area Segment
        areaSeg = (PI * Math.pow(radius,2))/360;

        String formattedCircum = String.format("%.2f",circumference);
        String formattedArea = String.format("%.2f",area);
        String formattedAreaSeg = String.format("%.2f",areaSeg);


        System.out.println("" +
                "Area: " +
                formattedArea +
                "\nCircumference:" +
                formattedCircum +
                "\nArea of circular segment: "+
                formattedAreaSeg);







    }

}
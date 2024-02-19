import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        //Variables are defined
        double price,vat,priceExVAT,consVAT;

        //Scanner class was defined
        System.out.println("Please Enter a Price of Product");
        Scanner input = new Scanner(System.in);

        //The value obtained from user is assigned a variable
        price = input.nextDouble();
        if (price >= 0 && price <= 1000) {
            consVAT = 0.18;
        } else {
            consVAT = 0.08;
        }

        vat = (price * consVAT);

        priceExVAT = price - vat;


        System.out.println(
                "Price Excluding VAT = " + priceExVAT +
                "\nPrice Including VAT = " + price +
                "\nValue Added TAX = " + vat);


    }





}
import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        //Variables are defined
        double price,vat,priceExVAT;

        //Scanner class was defined
        System.out.println("Please Enter a Price of Product");
        Scanner input = new Scanner(System.in);

        //The value obtained from user is assigned a variable
        price = input.nextDouble();

        priceExVAT = price - ((price/100) * 18);

        vat = ((price/100) * 18);


        System.out.println(
                "Price Excluding VAT = " + priceExVAT +
                "\nPrice Including VAT = " + price +
                "\nValue Added TAX = " + vat);


    }





}
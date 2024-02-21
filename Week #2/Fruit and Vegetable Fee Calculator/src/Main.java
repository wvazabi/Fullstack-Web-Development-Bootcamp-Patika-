import java.util.Scanner;
public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        // Fruit names and prices
        String[] fruits = {"Pear", "Apple", "Tomato", "Banana", "Eggplant"};
        double[] prices = {2.14, 3.67, 1.11, 0.95, 5.00};

        // Get kilograms for each fruit from the user
        double totalCost = 0;
        for (int i = 0; i < fruits.length; i++) {
            System.out.print("How many kilograms of " + fruits[i] + " ? : ");
            double kilos = scanner.nextDouble();
            totalCost += kilos * prices[i];
        }

        // Print the total cost
        System.out.println("Total Cost : " + String.format("%.2f", totalCost) + " TL");

    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declare variables
        String username, password;
        int balance = 2500;
        int tryCount = 3;
        int select = 0;

        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);


        // Start of login loop
        do {
            // Prompt the user to enter username and password
            System.out.print("Please Enter your username: ");
            username = input.nextLine();
            System.out.print("Please Enter your password: ");
            password = input.nextLine();

            // Check if username and password are correct
            if (username.equals("engeneskaya") && password.equals("123")) {
                System.out.println("\nSuccessfully log in");
                System.out.println("-----------------------");
                System.out.println("Welcome " + "deniz");

                // Start of transaction loop
                while (select != 4) {
                    // Display menu options
                    System.out.println(
                            "\nDeposit Money/1" +
                                    "\nWithdraw Money/2" +
                                    "\nInquiry Balance/3" +
                                    "\nExit/4");

                    // Prompt the user to select an option
                    System.out.print("\nPlease Enter Your Request: ");
                    select = input.nextInt();

                    // Process user's request based on the selected option
                    switch (select) {
                        case 1:
                            System.out.println("Enter the amount for deposit");
                            int amountD = input.nextInt();
                            balance += amountD;
                            break;
                        case 2:
                            System.out.println("Enter the amount for withdraw");
                            int amountW = input.nextInt();
                            if (amountW > balance) {
                                System.out.println("BIGGER THAN BALANCE!!!");
                            } else {
                                balance -= amountW;
                            }
                            break;
                        case 3:
                            System.out.println("Balance: " + balance);
                            break;
                        case 4:
                            System.out.println("Goodbye...");
                            tryCount = 0;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                // Decrement the try count if the username or password is incorrect
                --tryCount;
                // Check if the account should be blocked
                if (tryCount == 0) {
                    System.out.println("Account was blocked");
                } else {
                    // Prompt the user to try again if the username or password is incorrect
                    System.out.println("Username or password is incorrect! Please Try Again! ----left: " + tryCount );
                }
            }
        } while (tryCount > 0); // Continue the loop until try count is greater than 0
    }
}

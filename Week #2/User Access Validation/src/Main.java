import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String username;
        String password;
        String newPassword;
        String confirmPassword;
        final String oldPassword = "123456";
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter username
        System.out.println("Enter Username:");
        username = input.nextLine();

        // Prompt the user to enter password
        System.out.println("Enter Password:");
        password = input.nextLine();

        // Check if the username or password is invalid
        if (!username.equals("enes.kaya") || !password.equals(oldPassword)) {
            System.out.println("Invalid Username or Invalid Password ");

            // Ask the user if they want to reset their password
            System.out.println("Do you want to reset your password? (1 for yes, 2 for no)");
            int answer = input.nextInt();

            switch (answer) {
                case 1:
                    // Prompt the user to enter a new password
                    System.out.println("Enter New Password:");
                    newPassword = input.next();
                    // Check if the new password is the same as the old password
                    while (newPassword.equals(oldPassword)) {
                        System.out.println("The new password cannot be the same as the old password. Please try again!");
                        // Prompt the user to enter the new password again
                        System.out.println("Enter New Password:");
                        newPassword = input.next();
                    }
                    // Prompt the user to confirm the new password
                    System.out.println("Confirm New Password:");
                    confirmPassword = input.next();
                    // Check if the new password matches the confirmed password
                    while (!newPassword.equals(confirmPassword)) {
                        System.out.println("Passwords do not match. Please try again!");
                        // Prompt the user to enter the new password again
                        System.out.println("Enter New Password:");
                        newPassword = input.next();
                        // Prompt the user to confirm the new password again
                        System.out.println("Confirm New Password:");
                        confirmPassword = input.next();
                    }
                    System.out.println("The new password was changed successfully");
                    break;
                case 2:
                    System.out.println("Password reset cancelled.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 or 2.");
                    break;
            }

        } else {
            System.out.println("The login was successful.");
        }
    }
}

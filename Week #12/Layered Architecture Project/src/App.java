public class App {
    public static void main(String[] args) {
        // Presentation Layer
        CustomerManager customerManager = new CustomerManager();

        // Creating a new customer
        Customer newCustomer = new Customer();
        newCustomer.setMail("test@patika.dev");
        // Set other properties...

        // Save the customer using the CustomerManager
        boolean isSaved = customerManager.saveCustomer(newCustomer);

        if (isSaved) {
            System.out.println("Customer saved successfully!");
        } else {
            System.out.println("Failed to save customer.");
        }
    }
}
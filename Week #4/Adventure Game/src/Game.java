import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("------ Welcome to The Adventure Game!!! ------");
        System.out.println ("Please Enter your name: ");
        String playerName = "enes"; //input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Player Name: " + player.getName());

        player.selectedGameChar();
        Location location = null;

        while (true) {
            System.out.println("##################################################################");

            System.out.println("Please select a location" +
                    "\n Safe House: 1" +
                    "\n Tool Store: 2");

            System.out.println("##################################################################");


            int selectedLoc = input.nextInt();

            switch (selectedLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }




    }
}

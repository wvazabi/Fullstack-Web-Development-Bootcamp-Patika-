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
            player.playerInfo();
            System.out.println("##################################################################");

            System.out.println("Please select a location" +
                    "\n Safe House: 1" +
                    "\n Tool Store: 2" +
                    "\n Cave: 3" +
                    "\n Forest: 4" +
                    "\n River: 5" +
                    "\n Exit: 0");

            System.out.println("##################################################################");

//            Forest f = new Forest(player);
//            f.playerStats();
//            f.obstacleStats();

            int selectedLoc = input.nextInt();

            switch (selectedLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(location == null) {
                System.out.println("You are a coward :) *+&/* gAMe OvEr xD");
                break;
            }
            if(!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }




    }
}

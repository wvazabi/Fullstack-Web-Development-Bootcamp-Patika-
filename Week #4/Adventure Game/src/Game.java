import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("------ Welcome to The Adventure Game!!! ------");
        System.out.print ("Please Enter your name: ");
        String playerName = "enes"; //input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Player Name: " + player.getName());

        player.selectedGameChar();


    }
}

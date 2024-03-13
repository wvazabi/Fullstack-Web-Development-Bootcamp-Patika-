import java.util.Scanner;

public class Player {
    private String name;
    private int money;
    private int health;
    private int orjinalHealth;
    private int damage;
    private Inventory inventory;

    private String gameCharGame;

    Scanner input = new Scanner(System.in);


    public Player(String name) {

        this.name = name;
        // Default punch added to player
        this.inventory = new Inventory();
    }


    public void selectedGameChar() {
        GameChar[] gameCharList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("##################################################################");
        for (GameChar gameChar : gameCharList) {
            System.out.println("Character: " + gameChar.getName() +
                    "\t ID: " + gameChar.getiD() +
                    "\t Damage: " + gameChar.getDamage() +
                    "\t Health: " + gameChar.getHealth() +
                    "\t Money: " + gameChar.getMoney());

        }
        System.out.print("Please Select a Character: ");
        int selectedId = input.nextInt();

        switch (selectedId) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("##################################################################");


//        System.out.println("Character: " + this.getGameCharGame() +
//                "\t Damage: " + this.getDamage() +
//                "\t Health: " + this.getHealth() +
//                "\t Money: " + this.getMoney());


    }

    public void playerInfo() {
        System.out.println("Armor: " + this.inventory.getArmor().getName() +
                "\t Weapon: " + this.inventory.getWeapon().getName() +
                "\t Block: " + this.inventory.getArmor().getBlock() +
                "\t Damage: " + this.getDamage() +
                "\t Health: " + this.getHealth() +
                "\t Money: " + this.getMoney());

    }



    public void initPlayer (GameChar gameChar){
            this.setGameCharGame(gameChar.getName());
            this.setDamage(gameChar.getDamage());
            this.setHealth(gameChar.getHealth());
            this.setMoney(gameChar.getMoney());
            this.setOrjinalHealth(gameChar.getHealth());

        }

        public String getName () {
            return name;
        }

        public int getMoney () {
            return money;
        }

        public int getHealth () {
            return health ;
        }

        public int getDamage () {
            return damage + this.inventory.getWeapon().getDamage();
        }

        public void setName (String name){
            this.name = name;
        }

        public void setMoney ( int money){
            this.money = money;
        }

        public void setHealth ( int healt){
            if(healt < 0){
                this.health = 0;
            } else {
                this.health = healt;
            }

        }

        public void setDamage ( int damage){
            this.damage = damage;
        }

        public String getGameCharGame () {
            return gameCharGame;
        }

        public void setGameCharGame (String gameCharGame){
            this.gameCharGame = gameCharGame;
        }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}

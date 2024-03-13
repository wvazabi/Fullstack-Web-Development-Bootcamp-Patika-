public class SafeHouse extends NormalLoc{


    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    public boolean onLocation() {

        if(this.getPlayer().getInventory().food.equals("food") &&
                this.getPlayer().getInventory().fireWood.equals("firewood") &&
                this.getPlayer().getInventory().water.equals("water")) {
            System.out.println("Congratulations!!! ******///!!!You won the Game!!!wuhuuu///******");
            return false;
        }
        System.out.println("Location is " + this.getName() + " " + this.getPlayer().getGameCharGame() + " Health: " + this.getPlayer().getHealth());
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        System.out.println("Your health was refilled!!!");
        System.out.println(this.getPlayer().getGameCharGame() + " Health: " + this.getPlayer().getHealth());


        return true;
    }
}

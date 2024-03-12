public class SafeHouse extends NormalLoc{


    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    public boolean onLocation() {
        System.out.println("Location is " + this.getName());
        System.out.println("Your health was refilled!!!");
        return true;
    }
}

public class Inventory {
    Weapon weapon;
    Armor armor;

    String water = "";
    String fireWood = "";
    String food = "";

    public Inventory() {
        this.weapon = new Weapon("Punch", 0, 0, 0);
        this.armor = new Armor("undershirt", 0, 0, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean setWeapon(Weapon weapon) {
        this.weapon = weapon;
        return false;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getFireWood() {
        return fireWood;
    }

    public void setFireWood(String fireWood) {
        this.fireWood = fireWood;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}

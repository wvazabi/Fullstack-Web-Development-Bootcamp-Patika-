public class Inventory {
    Weapon weapon;
    Armor armor;

    public Inventory() {
        this.weapon = new Weapon("Punch",0,0,0);
        this.armor = new Armor("undershirt",0,0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

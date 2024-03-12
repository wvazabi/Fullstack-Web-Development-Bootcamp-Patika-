public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("---------- Welcome to ToolStore!!! ----------");
        System.out.println("Weapons: 1" +
                "\nArmors: 2" +
                "\nExit: 3");

        int selectedMenu = input.nextInt();

        while (selectedMenu < 1 || selectedMenu > 3) {
            System.out.println("Please enter a valid number");
            selectedMenu = input.nextInt();
        }

        switch (selectedMenu) {
            case 1:
                printWeapons();
                break;
            case 2:
                printArmors();
                break;
            case 3:
                System.out.println("Goodbye, and we look forward to seeing you again.");
                return true;
            default:
                return true;
        }

        return true;
    }

    public void printWeapons() {
        System.out.println("------------- Weapons --------------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("Weapon: " + w.getName() +
                    "\t <ID: " + w.getId() +
                    "\t Damage: " + w.getDamage() +
                    "\t Price: " + w.getPrice() + ">");
        }
        System.out.println("-------------------------------------");
        System.out.println("Please Select a Weapon");

        int selectedWeapon = input.nextInt();

        while (selectedWeapon < 1 || selectedWeapon > 3) {
            System.out.println("Please enter a valid number");
            selectedWeapon = input.nextInt();
        }

        Weapon selectedWeaponObj = Weapon.getWeaponObjById(selectedWeapon);

        if (selectedWeaponObj != null) {
            if(selectedWeaponObj.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("SORRY!!! There is no enough money to buy " + selectedWeaponObj.getName());

            } else {
                System.out.println(selectedWeaponObj.getName() + " has been bought");
                int balance = this.getPlayer().getMoney() - selectedWeaponObj.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranız " + this.getPlayer().getMoney());
            }

        }

    }

    public void printArmors() {
        System.out.println("Armors");
    }
}

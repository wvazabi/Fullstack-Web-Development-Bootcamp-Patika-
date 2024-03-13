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
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("Goodbye, and we look forward to seeing you again.");
                System.out.println("###################################################");

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

    }

    public void buyWeapon(){

        System.out.println("-------------------------------------");
        System.out.println("Please Select a Weapon");

        int selectedWeapon = input.nextInt();

        while (selectedWeapon < 1 || selectedWeapon > 3) {
            System.out.println("Please enter a valid number");
            selectedWeapon = input.nextInt();
        }

        Weapon selectedWeaponObj = Weapon.getWeaponObjById(selectedWeapon);

    // Weapon buy methods

        if (selectedWeaponObj != null) {
            if(selectedWeaponObj.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("SORRY!!! There is no enough money to buy " + selectedWeaponObj.getName());

            } else {
                System.out.println(selectedWeaponObj.getName() + " has been bought");
                int balance = this.getPlayer().getMoney() - selectedWeaponObj.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInventory().setWeapon(selectedWeaponObj);
                System.out.println("###################################################");

         }



        }


    }

    public void printArmor() {
        System.out.println("------------- Armors --------------");
        for (Armor a : Armor.armor()) {
            System.out.println("Armor: " + a.getName() +
                    "\t <ID: " + a.getId() +
                    "\t Block: " + a.getBlock() +
                    "\t Price: " + a.getPrice() + ">");
        }
    }

    public void buyArmor(){

        System.out.println("-------------------------------------");
        System.out.println("Please Select a Armor");

        int selectedArmor = input.nextInt();

        while (selectedArmor < 1 || selectedArmor > 3) {
            System.out.println("Please enter a valid number");
            selectedArmor = input.nextInt();
        }

        Armor selectedArmorObj = Armor.getArmorObjById(selectedArmor);
        // Armor buy methods

        if (selectedArmorObj != null) {
            if(selectedArmorObj.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("SORRY!!! There is no enough money to buy " + selectedArmorObj.getName());

            } else {
                System.out.println(selectedArmorObj.getName() + " has been bought");
                int balance = this.getPlayer().getMoney() - selectedArmorObj.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInventory().setArmor(selectedArmorObj);
                System.out.println("###################################################");


            }



        }


    }



}

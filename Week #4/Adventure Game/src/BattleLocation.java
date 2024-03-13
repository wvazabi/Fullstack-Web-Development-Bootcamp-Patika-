import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
    Obstacle obstacle;
    String award;

    Scanner input = new Scanner(System.in);

    public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player, name);
        this.award = award;
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {

        if (this.getPlayer().getInventory().water.equals(this.getAward()) ||
                this.getPlayer().getInventory().fireWood.equals(this.getAward()) ||
                this.getPlayer().getInventory().food.equals(this.getAward())) {
            return true;
        }

        int obsNum = getRandomObstacleNum();

        System.out.println("Your Location is: " + this.getName());
        System.out.println("!!!Danger!!! " + obsNum + " " + this.obstacle.getName() + " is coming");
        System.out.print("Do you wanna Fight or Run (f/r): ");

        String selectedCase = input.nextLine();

        selectedCase = selectedCase.toUpperCase();
        if (selectedCase.equals("F") && combat(obsNum)) {
            System.out.println("Congratulations!!! ****** You beat all enemies *******");

            if (this.getAward().equals("food")) {
                this.getPlayer().getInventory().setFood(this.getAward());
                System.out.println("You won the " + this.getPlayer().getInventory().food + " wuhuu!!!!");
            } else if (this.getAward().equals("firewood")) {
                this.getPlayer().getInventory().setFireWood(this.getAward());
                System.out.println("You won the " + this.getPlayer().getInventory().fireWood + " wuhuu!!!!");

            } else if (this.getAward().equals("water")) {
                this.getPlayer().getInventory().setWater(this.getAward());
                System.out.println("You won the " + this.getPlayer().getInventory().water + " wuhuu!!!!");
            }


            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {

            return false;
        }

        return true;
    }

    public boolean combat(int obstacleNumber) {

        System.out.println("Battle will be start be ready !!! ");

        for (int i = 1; i <= obstacleNumber; i++) {
            int randomDamage = rndNum();
            this.getObstacle().setDamage(randomDamage);
            this.obstacle.setHealth(this.obstacle.getOrjinalHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.obstacle.getHealth() > 0) {
                System.out.print("Battle or Run (b/r): ");
                String selectedCombat = input.nextLine().toUpperCase();
                if (selectedCombat.equals("B")) {
                    double randNum = randNum();
                    if (randNum <= 50) {
                        System.out.println("\"First you attack!!");
                        if (this.getPlayer().getHealth() > 0) {
                            this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getDamage());
                            afterHit(i);
                        }
                    } else {
                        if (this.obstacle.getHealth() > 0) {
                            System.out.println(this.obstacle.getName() + "Attack to you!!!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            this.getPlayer().getInventory().getArmor().setBlock(this.getPlayer().getInventory().getArmor().getBlock() - this.getObstacle().getDamage());
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit(i);
                        }
                    }

                    if (this.getPlayer().getHealth() <= 0) {
                        System.out.println("You are dead!!");
                        return false;
                    }
                } else {
                    return false;
                }


            }

            if (this.obstacle.getHealth() < this.getPlayer().getHealth()) {
                System.out.println("**********You Beat the Enemy Congratulations********");
                if (this.getObstacle().getName().equals("Snake")) {
                    double randNum = Math.random() * 100;
                    if (randNum < 45) {
                        System.out.println("There is no award bad luck :(");
                    } else {
                        double randNum2 = Math.random() * 56;
                        if (randNum2 < 15) {
                            // weapon award
                            if (randNum > 50) {
                                System.out.println("Award: Pistol");
                                int selectedWeapon = 1;
                                Weapon selectedWeaponObj = Weapon.getWeaponObjById(selectedWeapon);
                                this.getPlayer().getInventory().setWeapon(selectedWeaponObj);
                            } else if (randNum > 20 && randNum <= 50) {
                                System.out.println("Award: Sword");
                                int selectedWeapon = 2;
                                Weapon selectedWeaponObj = Weapon.getWeaponObjById(selectedWeapon);
                                this.getPlayer().getInventory().setWeapon(selectedWeaponObj);
                            } else {
                                System.out.println("Award: Rifle");
                                int selectedWeapon = 3;
                                Weapon selectedWeaponObj = Weapon.getWeaponObjById(selectedWeapon);
                                this.getPlayer().getInventory().setWeapon(selectedWeaponObj);
                            }
                        } else if (15 <= randNum2 && randNum2 < 30) {
                            //armor award
                            if (randNum > 50) {
                                System.out.println("Award: Light");
                                int selectedArmor = 1;
                                Armor selectedArmorObj = Armor.getArmorObjById(selectedArmor);
                                this.getPlayer().getInventory().setArmor(selectedArmorObj);
                            } else if (randNum > 20 && randNum <= 50) {
                                System.out.println("Award: Medium");
                                int selectedArmor = 2;
                                Armor selectedArmorObj = Armor.getArmorObjById(selectedArmor);
                                this.getPlayer().getInventory().setArmor(selectedArmorObj);
                            } else {
                                System.out.println("Award: Heavy");
                                int selectedArmor = 3;
                                Armor selectedArmorObj = Armor.getArmorObjById(selectedArmor);
                                this.getPlayer().getInventory().setArmor(selectedArmorObj);
                            }
                        } else {
                            // money
                            if (randNum > 50) {
                                System.out.println("Award: 1 Coin");
                                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                                System.out.println("The new balance is: \t" + this.getPlayer().getMoney());
                            } else if (randNum > 20 && randNum <= 50) {
                                System.out.println("Award: 5 Coin");
                                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                                System.out.println("The new balance is: \t" + this.getPlayer().getMoney());
                            } else {
                                System.out.println("Award: 10 Coin");
                                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                                System.out.println("The new balance is: \t" + this.getPlayer().getMoney());
                            }
                        }
                    }
                } else {
                    System.out.println("Award: " + this.obstacle.getAward());
                }

                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.obstacle.getAward());
                System.out.println("The new balance is: \t" + this.getPlayer().getMoney());
                System.out.println("######################################################");
            }

        }

        return true;
    }

    public double randNum() {

        return Math.random() * 100;
    }

    public void afterHit(int i) {
        System.out.println("Your Health: \t" + this.getPlayer().getHealth());
        System.out.println(i + "." + this.getObstacle().getName() + " Health: \t" + this.getObstacle().getHealth());
        if (this.obstacle.getName().equals("Snake")) {
            System.out.println(i + "." + this.getObstacle().getName() + " Damage: \t" + this.getObstacle().getDamage());
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void playerStats() {
        System.out.println(this.getPlayer().getGameCharGame() + " Health: \t" + this.getPlayer().getHealth());
        System.out.println(this.getPlayer().getGameCharGame() + " Damage: \t" + this.getPlayer().getDamage());
        System.out.println(this.getPlayer().getGameCharGame() + " Money:  \t" + this.getPlayer().getMoney());
        System.out.println("-------------------------------------------------------------------------------");

    }

    public void obstacleStats(int i) {
        System.out.println(this.getObstacle().getName() + " Health:    \t" + this.getObstacle().getHealth());
        System.out.println(this.getObstacle().getName() + " Damage:    \t" + this.getObstacle().getDamage());
        System.out.println(this.getObstacle().getName() + " Award:     \t" + this.getObstacle().getAward());
        System.out.println("-------------------------------------------------------------------------------");


    }

    public static int rndNum() {
        Random rand = new Random();
        int min = 3;
        int max = 6;
        int randomNumber = rand.nextInt((max - min) + 1) + min;
        return randomNumber;
    }

    public int getRandomObstacleNum() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}

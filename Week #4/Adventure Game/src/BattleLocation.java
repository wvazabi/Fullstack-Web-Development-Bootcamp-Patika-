import java.util.Random;

public abstract class BattleLocation extends Location {
    Obstacle obstacle;
    String award;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player, name);
        this.award = award;
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {

        int obsNum = getRandomObstacleNum();

        System.out.println("Your Location is: " + this.getName());
        System.out.println("!!!Danger!!! " + obsNum + " " + this.obstacle.getName() + " is coming");
        System.out.print("Do you wanna Fight or Run (f/r): ");
        String selectedCase = input.nextLine();
        selectedCase = selectedCase.toUpperCase();
        if (selectedCase.equals("F") && combat(obsNum)) {
            System.out.println("Congratulations!!! ****** You beat all enemies *******");
            return true;
        }

        if(this.getPlayer().getHealth() <= 0) {

            return false;
        }

        return true;
    }

    public boolean combat(int obstacleNumber) {

        System.out.println("Battle will be start be ready !!! ");

        for (int i = 1; i <= obstacleNumber; i++) {
            this.obstacle.setHealth(this.obstacle.getOrjinalHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.obstacle.getHealth() > 0) {
                System.out.print("Battle or Run (b/r): ");
                String selectedCombat = input.nextLine().toUpperCase();
                if(selectedCombat.equals("B")) {
                    System.out.println("\"First you attack!!");
                    this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getDamage());
                    afterHit(i);
                    if(this.obstacle.getHealth() > 0) {
                        System.out.println(this.obstacle.getName() + "Attack to you!!!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage );
                        afterHit(i);
                    }
                    if(this.getPlayer().getHealth() <= 0) {
                        System.out.println("You are dead!!");
                        return false;
                    }
                } else {
                    return false;
                }


            }

            if(this.obstacle.getHealth() < this.getPlayer().getHealth()) {
                System.out.println("**********You Beat the Enemy Congratulations********");
                System.out.println("Award: " + this.obstacle.getAward());
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.obstacle.getAward());
                System.out.println("The new balance is: \t" + this.getPlayer().getMoney());
                System.out.println("######################################################");
            }

            //return true;
        }

        return true;
    }

    public void afterHit(int i) {
        System.out.println("Your Health: \t" + this.getPlayer().getHealth());
        System.out.println(i + "." + this.getObstacle().getName() + " Health: \t" + this.getObstacle().getHealth());
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

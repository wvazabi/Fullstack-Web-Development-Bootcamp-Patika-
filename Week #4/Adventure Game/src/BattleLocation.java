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
        System.out.println("Do you wanna Fight or Run (f/r)");
        String selectedCase = input.nextLine();
        selectedCase = selectedCase.toUpperCase();
        if (selectedCase.equals("F")) {
            System.out.println("Battle will be start be ready !!! ");
        }

        return true;
    }

    public boolean combat(int obstacleNumber) {

        for (int i = 0; i < obstacleNumber; i++) {
            playerStats();
            obstacleStats();

            while (this.getPlayer().getHealth() > 0 && this.obstacle.getHealth() > 0) {

            }
        }

        return false;
    }

    public void playerStats() {
        System.out.println(this.getPlayer().getGameCharGame() + " Health: \t" + this.getPlayer().getHealth());
        System.out.println(this.getPlayer().getGameCharGame() + " Damage: \t" + this.getPlayer().getDamage());
        System.out.println(this.getPlayer().getGameCharGame() + " Money:  \t" + this.getPlayer().getMoney());
        System.out.println("-------------------------------------------------------------------------------");

    }

    public void obstacleStats() {
        System.out.println(this.getObstacle().getName() + " Health: \t" + this.getObstacle().getHealth());
        System.out.println(this.getObstacle().getName() + " Damage: \t" + this.getObstacle().getDamage());
        System.out.println(this.getObstacle().getName() + " Award:  \t" + this.getObstacle().getAward());
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

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
        if (selectedCase.equals("F")){
            System.out.println("Battle will be start be ready !!! ");
        }

            return true;
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

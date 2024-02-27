public class Match {
    Fighter fighter1;
    Fighter fighter2;

    int minWeight;
    int maxWeight;



    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.fighter1 = f1;
        this.fighter2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    boolean isCheck(Fighter f1, Fighter f2) {
        return (((f1.weight >= this.minWeight) && (f1.weight <= this.maxWeight)) && ((f2.weight >= this.minWeight) && (f2.weight <= this.maxWeight)));
    }

    void run() {
        if (isCheck(this.fighter1, this.fighter2)) {
            while (this.fighter1.healt > 0 && this.fighter2.healt > 0) {
                System.out.println("===== New Round =====");
                System.out.println();
                double randNum = Math.random() * 100;
                if(randNum <= 50) {
                    fighter2.healt = fighter1.hit(fighter2);
                    if(isWin()) {
                        break;
                    }
                } else {
                    fighter1.healt = fighter2.hit(fighter1);
                    if(isWin()) {
                        break;
                    }
                }


                System.out.println();
                System.out.println(this.fighter1.name + " HEALTH = " + this.fighter1.healt);
                System.out.println(this.fighter2.name + " HEALTH = " + this.fighter2.healt);
                System.out.println();
            }

        } else {
            System.out.println("The athletes' weights don't match");
        }
    }

    boolean isWin() {
        if (this.fighter1.healt == 0) {
            System.out.println("\n" + this.fighter2.name + " is WIN!");
            return true;
        }

        if (this.fighter2.healt == 0) {
            System.out.println("\n" + this.fighter1.name + " is WIN!");
            return true;
        }
        else {
            return false;
        }
    }


}

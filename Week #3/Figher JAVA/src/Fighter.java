public class Fighter {
    String name;
    int weight;
    int damage;
    int healt;
    int dodge;

    Fighter(String name, int damage, int healt, int weight, int dodge) {
        this.name = name;
        this.weight = weight;
        this.damage = damage;
        this.healt = healt;
        this.dodge = dodge;
    }

    int hit(Fighter foe) {
        System.out.println(this.name + " => " + foe.name + " " + this.damage + " damaged");
        if(foe.isDodge()) {
            System.out.println("--- " + foe.name + " dodged ---\n");
            return foe.healt;
        }
        if (foe.healt - this.damage < 0) {
            return 0;
        }

        return foe.healt - this.damage;
    }


    boolean isDodge(){
        double dodgeRand = Math.random() * 100;
        return dodgeRand <= this.dodge;
    }
}

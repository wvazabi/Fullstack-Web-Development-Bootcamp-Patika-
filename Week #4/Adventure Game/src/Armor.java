public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;

    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armor() {

        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Light", 1, 1, 10);
        armorList[1] = new Armor("Medium", 2, 3, 20);
        armorList[2] = new Armor("Heavy", 3, 5, 30);

        return armorList;
    }

    public static Armor getArmorObjById(int id) {
        Weapon weapon = null;

        for (Armor a : armor()) {
            if(a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        if(block < 0) {
            this.block = 0;
        } else {
            this.block = block;
        }

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

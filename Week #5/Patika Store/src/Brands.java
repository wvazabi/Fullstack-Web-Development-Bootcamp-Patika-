import java.util.*;

public class Brands {

    private  int id;
    private  String name;
    static ArrayList<Brands> brandsList = new ArrayList<Brands>();

    static {
        brandsList.add(new Brands(1,"Samsung"));
        brandsList.add(new Brands(2,"Lenovo"));
        brandsList.add(new Brands(3,"Apple"));
        brandsList.add(new Brands(4,"Huawei"));
        brandsList.add(new Brands(5,"Casper"));
        brandsList.add(new Brands(6,"Asus"));
        brandsList.add(new Brands(7,"HP"));
        brandsList.add(new Brands(8,"Xiaomi"));
        brandsList.add(new Brands(9,"Monster"));


        brandsList.sort(new BrandsComparator());
    }



    public Brands(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public  String toString() {
        return "Brands{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}

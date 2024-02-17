package setGet;

public class Teacher {

    private int age = 22;
    private String name = "";

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int setAge(int age) {
        this.age = age;
        return age;
    }


}

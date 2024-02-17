package setGet;

import Encapsulation.Encapsulation;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello xd!");

        Teacher th = new Teacher();
        System.out.println(th.getAge());
        System.out.println(th.getName());
        System.out.println(th.setAge(28));

    }

}

package ArrayList;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add("enes");
        System.out.println(arr);
        System.out.println(arr.get(0));

        boolean x = arr.contains("enes");
        System.out.println(x);
        System.out.println(arr.size());


    }
}

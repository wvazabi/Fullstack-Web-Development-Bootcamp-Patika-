import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner STDIN = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> number = new ArrayList<>();

        int n = STDIN.nextInt(); // n lines

        for (int i = 0; i < n; i++) {
            int d = STDIN.nextInt(); // d
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                innerList.add(STDIN.nextInt());
            }
            number.add(innerList);
        }

        // q

        int q = STDIN.nextInt();

        for (int i = 0; i < q; i++) {
            int x = STDIN.nextInt();
            int y = STDIN.nextInt();

            if ( x - 1 < number.size() && y - 1 < number.get(x - 1).size()) {
                System.out.println(number.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }


        }

    }
}

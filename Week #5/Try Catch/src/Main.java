import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int x;
        int y;
        Scanner STDIN = new Scanner(System.in);
        try{
            x = STDIN.nextInt();
            y = STDIN.nextInt();
            System.out.println(x/y);

        } catch(InputMismatchException e){
            System.out.println(e.getClass().getName());


        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getName()+": " +e.getMessage());

        } catch (Exception e){
            System.out.println( e.getMessage());
        } finally {
            STDIN.close(); // Scanner nesnesini kapatma
        }


    }
}

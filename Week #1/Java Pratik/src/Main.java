
import  java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String [] names = new String[5];
//
//        names[0] = "enes0";
//        names[1] = "enes1";
//        names[2] = "enes2";
//        names[3] = "enes3";
//        names[4] = "enes4";
//
//        System.out.println(Arrays.toString(names));
// Java split metodu ile cümleyi bölme işlemi

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your Sentence");
        String sentence = sc.nextLine();
        System.out.println(sentence);

        String [] words = sentence.split(" ");
        System.out.println(words[0]);
        System.out.println(words[1]);
        System.out.println(words[2]);



    }
}


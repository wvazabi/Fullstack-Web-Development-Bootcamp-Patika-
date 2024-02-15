
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
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please Enter Your Sentence");
//        String sentence = sc.nextLine();
//        System.out.println(sentence);
//
//        String [] words = sentence.split(" ");
//        System.out.println(words[0]);
//        System.out.println(words[1]);
//        System.out.println(words[2]);

        // iki boyutlu arraylerde işlemler

//        String[] name = {"Enes0","Enes2","Enes3","Enes4","Enes5"};
//        int index = 0;
//
//        while( index < name.length ) {
//            System.out.println(name[index]);
//            index++;
//        }
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("sayı giriniz");
//
//        int num = sc.nextInt();
//        int sum = 0;
//
//
//        while ( num > 0 ) {
//            sum += (num % 10);
//            num /= 10;
//
//        }
//
//        System.out.println(sum);

        int[] numbers = { 3,5 };
        int index = 0;
        int toplam = 0;
        int lenght = numbers.length;
        System.out.println(lenght);


        while( index < lenght) {
            System.out.println(numbers[index]);
            toplam += numbers[index];
            index++;
        }

        System.out.println("\n" + toplam);






    }
}


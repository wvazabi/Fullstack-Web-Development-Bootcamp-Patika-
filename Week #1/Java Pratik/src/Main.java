
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

//        int[] numbers = { 3,5 };
//        int index = 0;
//        int toplam = 0;
//        int lenght = numbers.length;
//        System.out.println(lenght);
//
//
//        while( index < lenght) {
//            System.out.println(numbers[index]);
//            toplam += numbers[index];
//            index++;
//        }
//
//        System.out.println("\n" + toplam);

        // for döngüsü

//        String[] arr = {"Enes", "Nilay", "Araba", "Kamyon", "Makina", "Lego"};
//        int lenght = arr.length;
//
//        for( int i = 0; i < lenght; i++) {
//            System.out.println(arr[i]);
//        }

//
//
//        for( int i = 20; i < 120; i++) {
//            if (i % 3 == 0) {
//                System.out.println(i);
//            }
//
//        }

//        // root calculator
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter number: \n");
//        int num = sc.nextInt();
//
//        for(int i = 0; i < num; i++){
//            if (i * i == num){
//                System.out.println("root of the number is: " + i);
//            }
//        }
// multiplication table
//
//        for (int i = 1; i < 10; i++){
//            for(int j = 1; j < 10; j++){
//                System.out.println(i + " * " + j + " = " + (i * j));
//            }
//            System.out.println("\n");
//        }
//
//        String[] names = {"A","B","A","A","C","V","B","C","X","G","H","F","E","E"};
//        int nameLenght = names.length;
//        int[] count = new int[nameLenght];
//
//
//        for(int i = 0; i < nameLenght; i++) {
//            int temp = 0;
//            for(int j = 0; j < nameLenght; j++) {
//                if(names[i].equals(names[j])) {
//                    temp += 1;
//                }
//                count[i] = temp;
//            }
//        }
//
//        for(int i = 0; i < nameLenght; i++) {
//            System.out.println(names[i] + " characters: "+count[i] +" count contains ");
//        }
        Boolean bool = new Boolean(false);
        String[] names = {"A","B","A","A","C","V","B","C","X","G","H","F","E","E"};
        int nameLenght = names.length;
        String x = new String();
        x = "a";

        for(int i = 0; i < nameLenght; i++) {
            if (names[i].equals(x)){
                bool = true;
            }
        }

        System.out.println("Dizide karakter olma durumu " + bool);





    }
}


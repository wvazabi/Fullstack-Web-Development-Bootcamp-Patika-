import java.util.*;
import java.io.*;

class Main {

    public static String LetterCapitalize(String str) {

        char[] charArray = str.toCharArray();


        for(int i = 0; i < charArray.length; i++) {

            if(i == 0) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
            if(charArray[i] == ' '){
                charArray[i+1] = Character.toUpperCase(charArray[i + 1]);
            }
        }
        // Diziden String tanımlama
        String newStr = new String(charArray);

        return newStr;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterCapitalize(s.nextLine()));
    }

}
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your sentences");
        String sentences = input.nextLine();

        String[] words = sentences.split(" ");



        Map<String, Integer> wordsAndCounts = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            wordsAndCounts.put(words[i], 0);
        }

        for (int i = 0; i < words.length; i++) {

            if (wordsAndCounts.containsKey(words[i])) {
                int count = wordsAndCounts.get(words[i]);
                wordsAndCounts.put(words[i], count + 1);
            } else {
                wordsAndCounts.put(words[i], 1);
            }
        }

        int maxNum = 0;
        String mostFrequentWord = "";

        for (Map.Entry<String, Integer> entry : wordsAndCounts.entrySet()) {
            if (entry.getValue() > maxNum){
                maxNum = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }


            System.out.println("The most frequent word is: " + mostFrequentWord);
        //System.out.println(wordsAndCounts);


    }
}
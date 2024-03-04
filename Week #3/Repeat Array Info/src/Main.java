import java.util.Arrays;

public class Main {
    static boolean isFind(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] list = {6, 10,10,5,5,8,5,5,534,5,8,5,2,7};
        int[] repeat = new int[list.length];
        int counter = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if ((i != j) && (list[i] == list[j])) {
                    if (!isFind(repeat, list[i])) {
                        repeat[counter++] = list[i];
                    }

                    break;
                }

            }
        }
        int[] ctrArray = new int[repeat.length];


        for(int i = 0; i < repeat.length; i++) {
            int ctr = 0;
            for (int j = 0; j < list.length; j++) {
                if (list[j] == repeat[i]) {
                    ctr++;
                }
            }
            ctrArray[i] = ctr;



        }

        for(int i = 0; i < repeat.length; i++){
            if(repeat[i] != 0) {
                System.out.println(repeat[i] + " sayısı " + ctrArray[i]);
            }
        }




    }
}
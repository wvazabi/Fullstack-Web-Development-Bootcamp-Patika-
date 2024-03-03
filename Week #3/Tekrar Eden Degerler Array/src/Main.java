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

        int[] list = {6, 4, 1, 9, 6, 7, 3, 8, 3, 4, 90, 42, 3, 56, 5};
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

        for (int value : repeat) {
            if (value != 0) {
                System.out.println(value);
            }
        }


    }
}
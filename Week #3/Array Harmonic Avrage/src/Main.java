public class Main {
    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5};
        double sum = 0.0 ;
        for(int i = 0; i < arr.length; i++) {
             sum += (1.0/arr[i]);
        }

        //double average = sum / arr.length;
        double average =  arr.length / sum;
        System.out.println(average);
    }
}
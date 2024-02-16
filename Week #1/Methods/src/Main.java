public class Main {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 12;
        int[] arr = {3,5,6,12,7,4};

        //sum(num1,num2);
        find(num1,arr);



    }

    public static void sum(int num1, int num2) {
        int sum = num1 + num2;

        System.out.println(sum);
    }

    public static void find(int num1, int[] arr) {

        boolean find = false;

        for(int num : arr) {
            if(num == num1) {
                find = true;
                break;
            }
        }

        System.out.println("find : " + find);

    }


}
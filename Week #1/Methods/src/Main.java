public class Main {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 6;
        int[] arr = {3,5,6,12,7,4};

        //sum(num1,num2);
       // find(num1,arr);
//       int sum =  sumR(num1, num2);
//       System.out.println(sum);

        int fact = factorial(num2);
        System.out.println(fact);

    }


    public static int factorial(int num) {
        int result = 1;

        for(int i = 1; i <= num; i++) {
            result *= i;
        }

        return result;
    }
    public static int sumR(int num1, int num2) {
        int sum = num1 + num2;

        return sum;
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
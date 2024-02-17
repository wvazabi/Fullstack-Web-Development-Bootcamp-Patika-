public class Main {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 6;
        int[] arr = {21,15,14,12,6,4};


        //sum(num1,num2);
       // find(num1,arr);
//       int sum =  sumR(num1, num2);
//       System.out.println(sum);
//
//        int fact = factorial(num2);
//        System.out.println(fact);
//
//        int maxNum = maxNumber(arr);
//        System.out.println(maxNum);
//        boolean bool = maxSort(arr);
//        System.out.println("sorting status: " + bool);

    Car car = new Car();
        //System.out.println(car.name + car.model);

        Library lib = new Library();
//        System.out.println(lib.numOfBooks);
//        System.out.println(lib.closeDate);
//        System.out.println(lib.esDate);

        Student st = new Student();

//        st.regStudent();
//        st.regStudent();
//        st.regStudent();
//        st.removeStudent();
//        System.out.println(st.numOfStudent);

//        Teacher th = new Teacher();
//        th.print();

        Calculator cal = new Calculator();
        cal.sum(num1,num2);


    }

    public static boolean maxSort(int[] num){
        boolean bool = true;
        for(int i = 0; i < (num.length - 1); i++) {
           for(int j = i+1; j < (num.length); j++) {
               if (num[i] < num[j]) {
                   bool = false;
                   break;
               }
           }
        }
        return bool;
    }
//     if (num[i] > num[i+1]) {
//        bool = true;
//    }
//            else {
//        bool = false;
//    }
    public static int maxNumber(int[] num){
        int maxNum = 0;

        for(int sayi : num) {
           if(sayi > maxNum){
               maxNum = sayi;
           }
        }

        return maxNum;
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
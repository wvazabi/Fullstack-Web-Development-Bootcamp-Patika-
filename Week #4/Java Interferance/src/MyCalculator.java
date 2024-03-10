class MyCalculator implements AdvancedArithmetic{
    int sum = 0;
    public int divisor_sum(int n){
        //System.out.println(n);
        for(int i = 1; i < 10; i++){
            if((n % i) == 0){
                sum += i;
                System.out.println(sum);
            }

        }
        return sum;
    }
}
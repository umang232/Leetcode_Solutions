class Solution {
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int t1 =0;
        int t2 =1;
        int t3 = 1;
        int i = 0;
        int sum = 0;
        while(i <= n-3){
            sum = t1+t2+t3;
            i++;
            int temp = t3;
            t3 = sum;
            t1 = t2;
            t2 = temp;
        }
        return sum;
    }
}
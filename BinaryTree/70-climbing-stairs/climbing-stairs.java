class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int fir = 1;
        int sec = 2;
        for(int i=2;i<n;i++){
            int temp = fir+sec;
            fir = sec;
            sec = temp;
        }
        return sec;
    }
}
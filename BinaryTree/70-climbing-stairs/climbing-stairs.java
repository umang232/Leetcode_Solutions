class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int [] arr = new int[n];
        int jump1 = 1;
        int jump2 = 2;
        int i = 2;
        while(i<=n-1){
            int temp = jump1 + jump2;
            i++;
            jump1 = jump2;
            jump2 = temp;
        }
        return jump2;
    }
}
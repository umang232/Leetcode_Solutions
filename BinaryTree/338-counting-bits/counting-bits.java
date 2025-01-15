class Solution {
    public int[] countBits(int n) {
        int[] ans  = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = noOfOne(i);
        }
        return ans;
    }
    public int noOfOne(int i){
        int count = 0;
        while(i>0){
            i = i&(i-1);
            count++;
        }
        return count;
    }
}
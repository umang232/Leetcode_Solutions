class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            int length = 0;
            for(int j = 0;j<i;j++){
                if(nums[j]< nums[i]){
                    length = Math.max(length,dp[j]);
                }
            }
            dp[i] = length + 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
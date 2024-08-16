class Solution {
    public int rob(int[] nums) {
        int [] cost = new int[nums.length];
        int n = nums.length;
        
        if(n == 1) return nums[0];
        if( n== 2){
            return Math.max(nums[1], nums[0]);
        }
        cost[n-1] =nums[n-1];
        cost[n-2] = nums[n-2];
        cost[n-3] = nums[n-1]+nums[n-3];
        for(int i=n-4;i>=0;i--){
            cost[i] = nums[i] + Math.max(cost[i+2],cost[i+3]);
        }
        return Math.max(cost[0],cost[1]);
    }
}

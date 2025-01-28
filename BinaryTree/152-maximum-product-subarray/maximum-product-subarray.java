class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1;
        int curMin = 1;
        int ans = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                curMax= 1;
                curMin = 1;
                ans = Math.max(ans,0);
            }else{
                int temp = curMax;
                curMax = Math.max(curMin*nums[i], Math.max(curMax*nums[i],nums[i]));
                curMin = Math.min(temp*nums[i],Math.min(curMin*nums[i],nums[i]));
                ans = Math.max(ans,curMax);
            }
            
        }
        return ans;
    }
}
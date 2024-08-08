class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int temp = nums[0];
        for(int i=1;i<nums.length;i++){
            if(temp + nums[i]>nums[i]){
                temp = temp+nums[i];
            }
            else{
                ans = Math.max(ans,temp);
                temp = nums[i];
            }
            ans = Math.max(ans,temp);
        }
        return ans;
    }
}
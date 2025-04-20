class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        if(nums.length == 1){
            return true;
        }
        if(maxJump == 0){
            return false;
        }
        for(int i=1;i<nums.length - 1;i++){
            maxJump = Math.max(maxJump,i+nums[i]);
            if(maxJump <= i){
                return false;
            }
            if(maxJump >= nums.length-1){
                return true;
            }
        }
        return true;
    }
}
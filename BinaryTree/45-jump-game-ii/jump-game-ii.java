class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int maxJump = nums[0];
        int minJump = 1;
        if(maxJump >= nums.length - 1){
            return 1;
        }
        int i = 1;
        int j = maxJump;
        while(true){
            minJump+=1;
            for(int k = i;k<=j;k++){
                maxJump = Math.max(maxJump, k+nums[k]);
                if(maxJump >= nums.length -1){
                    return minJump;
                }
            }
            i = j+1;
            j = maxJump;
        }
    }
}
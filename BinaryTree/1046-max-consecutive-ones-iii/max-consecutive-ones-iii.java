class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxL = 0;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                temp ++;
                maxL = Math.max(maxL,temp);
            }else if(nums[i] == 0 && k > 0){
                temp ++;
                maxL = Math.max(maxL,temp);
                k--;
            
            }else{
                while(nums[left] != 0){
                    left++;
                }
                
                left++;
                temp = (i-left)+1;
                maxL = Math.max(maxL,temp);
            }
        }
        return Math.max(maxL,temp);
    }
}
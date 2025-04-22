class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxL = 0;
        int temp = 0;
        int a = k;
        for(int i=0;i<nums.length;i++){
            
            // if(nums[i] == 0 && temp == 0){
            //     left++;
            // }
            if(nums[i] == 1){
                temp ++;
                maxL = Math.max(maxL,temp);
            }else if(nums[i] == 0 && a > 0){
                temp ++;
                maxL = Math.max(maxL,temp);
                a--;
            
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
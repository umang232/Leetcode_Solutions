class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        if(nums.length <=2){
            return nums.length;
        }
        for(int i=2;i<nums.length;i++){
            if(nums[i] == nums[k] && nums[i] == nums[k-1]){
                continue;
            }else{    
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }
}
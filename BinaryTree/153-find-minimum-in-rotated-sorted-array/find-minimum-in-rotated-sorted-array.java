class Solution {
    public int findMin(int[] nums) {
        int i=0;
        int j = nums.length-1;
        while(i<j){
            int m  = (i+j)/2;
            if(nums[i]<=nums[m] && nums[m] <nums[j]){
                return nums[i];
            }
            if(nums[i]>=nums[m] && nums[m] >nums[j]){
                return nums[j];
            }
            if(nums[i]<nums[m] && nums[m] > nums[j]){
                i = m+1;
            }else{
                j = m;
            }
        }
        return nums[i];
    }
}
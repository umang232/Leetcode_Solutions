class Solution {
    public int searchInsert(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        int mid =0;
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                low = mid+1;

            }else{
                high = mid-1;
            }
        }
        if(nums[mid]>target){
            return mid;
        }else{
            return mid+1;
        }
    }
}
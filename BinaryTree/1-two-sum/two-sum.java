import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(target-nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]) && hm.get(nums[i])!=i){
                int[] ret = new int[2];
                ret[0] = hm.get(nums[i]);
                ret[1] = i;
                return ret;
            }
        }
        return null;
    }
}
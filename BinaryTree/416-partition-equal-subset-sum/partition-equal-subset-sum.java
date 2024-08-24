class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int n:nums){
            sum+=n;
        }
        if(sum %2 != 0){
            return false;
        }
        int target = sum/2;
        System.out.println(target);
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);
        for(int i=nums.length-1;i>=0;i--){
            HashSet<Integer> n1 = new HashSet<>();
            for(int n:hs){
                
                n1.add(nums[i]+n);
                n1.add(n);
                if(nums[i] + n ==target){
                    return true;
                }
                
            }
            hs = n1;
        }
        return false;
        
    }
}
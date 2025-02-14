class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(ans,temp,nums,0);
        return ans;
    }
    public void helper(List<List<Integer>> ans, List<Integer> temp,int[] nums,int start){
        ans.add(new ArrayList<>(temp));
        for(int i= start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            helper(ans,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}
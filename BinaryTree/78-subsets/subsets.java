class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp =new ArrayList<>();
        generateSubsets(nums,temp,0);
        return ans;
    }
    public void generateSubsets(int[]nums, List<Integer> temp,int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        generateSubsets(nums,temp,i+1);
        temp.remove(temp.size()-1);
        generateSubsets(nums,temp,i+1);
    }
}
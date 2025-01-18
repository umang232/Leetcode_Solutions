class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        calculateSum(candidates,temp,0,target);
        return ans;
    }
    public void calculateSum(int[]candidates,List<Integer> temp,int i,int target){
        if(i >= candidates.length || target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(candidates[i]);
        calculateSum(candidates,temp,i,target-candidates[i]);
        temp.remove(temp.size()-1);
        calculateSum(candidates,temp,i+1,target);

    }
}
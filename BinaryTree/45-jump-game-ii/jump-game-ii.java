class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int fur = 0;
        int l = 0;
        int r = 0;
        while(r < nums.length -1){
            for(int i = l;i<=r;i++){
                fur = Math.max(fur,i+nums[i]);
            }
            l = r;
            r = fur;
            ans++;
        }
        return ans;
    }
    
}
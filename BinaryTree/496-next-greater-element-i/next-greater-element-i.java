class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<nums2.length;i++){
            if(st.isEmpty()){
                st.push(nums2[i]);
            }else if(nums2[i] > st.peek()){
                while(!st.isEmpty() && st.peek() < nums2[i]){
                    map.put(st.pop(),nums2[i]);
                }
                st.push(nums2[i]);
            }else{
                st.push(nums2[i]);
            }
        }
        System.out.println(map);
        int ans [] = new int[nums1.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                ans[i] = map.get(nums1[i]);
            }
        }
        return ans;
    }
}
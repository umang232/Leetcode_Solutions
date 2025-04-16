class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums2[nums2.length-1], -1);
        Stack<Integer> st = new Stack<>();
        st.push(nums2[nums2.length-1]);
        for(int i= nums2.length - 2;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            int ele = st.isEmpty() ? -1 : st.peek();
            map.put(nums2[i],ele);
            st.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<res.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
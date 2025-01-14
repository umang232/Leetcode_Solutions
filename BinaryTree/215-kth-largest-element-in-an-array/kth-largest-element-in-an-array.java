class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cur = 0;
        while(cur < k){
            pq.add(nums[cur]);
            cur++;
        }
        for(int j=cur;j<nums.length;j++){
            if(nums[j]>pq.peek()){
                pq.poll();
                pq.add(nums[j]);
            }
        }
        return pq.peek();
    }
}
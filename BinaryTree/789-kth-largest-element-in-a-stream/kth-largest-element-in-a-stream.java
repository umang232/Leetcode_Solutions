class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k=0;
    int cur = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(cur < k){
            pq.add(val);
            cur ++;
            return pq.peek();
        }
        else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
            return pq.peek();
        }else{
            return pq.peek();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
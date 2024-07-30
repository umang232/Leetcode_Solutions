class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int val1 = pq.remove();
            int val2 = pq.remove();
            pq.add(val1-val2);
        }
        if(pq.size() == 1){
            return pq.peek();
        }else{
            return 0;
        }
    }
}
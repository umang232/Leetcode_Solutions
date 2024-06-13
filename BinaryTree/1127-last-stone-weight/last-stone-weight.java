class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int num = pq.poll();
            int num2 = pq.poll();
            if(num != num2){
                pq.add(num-num2);
            }
        }
        if(pq.size()>0){
            return pq.poll();
        }else{
            return 0;
        }
    }
}
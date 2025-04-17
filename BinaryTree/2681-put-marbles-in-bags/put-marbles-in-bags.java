class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int i=0;i<n-1;i++){
            int sum = weights[i] + weights[i+1];
            minHeap.offer(sum);
            if(minHeap.size() > k-1){
                minHeap.poll();
            }
            maxHeap.offer(sum);
            if(maxHeap.size() > k-1){
                maxHeap.poll();
            }
        }
        long minCost = 0, maxCost = 0;
        while(!minHeap.isEmpty()){
            minCost += minHeap.poll();
        }
        while(!maxHeap.isEmpty()){
            maxCost += maxHeap.poll();
        }
        return maxCost - minCost;
    }
}
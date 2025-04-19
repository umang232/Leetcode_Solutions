class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int cur_height = 0;
        
        for(int i=1;i<heights.length;i++){
            if(heights[i] > heights[i-1]){
                if(minHeap.size() < ladders){
                    minHeap.offer(heights[i]-heights[i-1]);
                }else{
                    if(!minHeap.isEmpty() && minHeap.peek() < heights[i]-heights[i-1]){
                        if(minHeap.peek() + cur_height <=bricks){
                            cur_height += minHeap.poll();
                            minHeap.offer(heights[i]-heights[i-1]);
                        }else{
                            return i-1;
                        }
                    }else{
                        if(cur_height + heights[i]-heights[i-1] <= bricks){
                            cur_height += heights[i]-heights[i-1];
                        }else{
                            return i-1;
                        }
                    }
                }
            }
        }
        return heights.length-1;
    }
}
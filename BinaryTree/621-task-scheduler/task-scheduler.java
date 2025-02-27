class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int [] arr = new int[26];
        for(char c:tasks){
            arr[c-'A']++;
        }
        for(int val:arr){
            if(val>0){
                pq.add(val);
            }
        }
        int time =0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int val = pq.poll();
                val --;
                if(val>0){
                    queue.add(new Pair(val,time+n));
                }
            }
            if(!queue.isEmpty() && queue.peek().getValue() ==time){
                pq.add(queue.poll().getKey());
            }
        }
        return time;
    }
}
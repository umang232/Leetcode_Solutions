class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for(int [] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1],time[2]);
        } 
        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k] = 0;
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{k,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curWeight = cur[1];
            
            for(int next : map.getOrDefault(curNode, new HashMap<>()).keySet()) {
                int nextweight = map.get(curNode).get(next);
                
                if(curWeight + nextweight < dis[next]) {
                    dis[next] = curWeight + nextweight;
                    queue.add(new int[]{next, curWeight + nextweight});
                }
            }
        }
        int res = 0;
        for(int i=1; i<=n; i++) {
            if(dis[i] > res) {
                res = Math.max(res, dis[i]);
            } 
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
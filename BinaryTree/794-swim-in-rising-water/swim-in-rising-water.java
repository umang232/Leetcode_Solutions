class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<String> set = new HashSet<>();

        pq.offer(new int[]{grid[0][0], 0 ,0});
        set.add("0,0");
        int[][] dirs = new int[][]{
    {0, 1}, 
    {0, -1}, 
    {1, 0}, 
    {-1, 0}
};



        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[1] == n-1 && temp[2] == n-1){
                return temp[0];
            }
            for(int[] dir: dirs){
                int neiR = temp[1] + dir[0];
                int neiC = temp[2] + dir[1];
                String d = neiR+","+neiC;
                if(neiR < 0 || neiR == n || neiC < 0 || neiC == n || set.contains(neiR + "," + neiC)){
                    continue;
                }
                set.add(neiR+","+neiC);
                pq.offer(new int[] {Math.max(temp[0], grid[neiR][neiC]), neiR, neiC});

            }
        }
        return -1;
    }
}
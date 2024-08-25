class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        int count = 0;
        int [][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!queue.isEmpty()&& fresh != 0){
            count ++;
            int s = queue.size();
            for (int i = 0; i < s; i += 1) {
                int[] rotten = queue.poll();
                int r = rotten[0];
                int c = rotten[1];
                for(int[] dir : dirs){
                    int x = r + dir[0], y = c + dir[1];
                    if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[] {x,y});
                        fresh --;
                    }
                }
            }
        }

        return fresh == 0?count:-1;
    }
}
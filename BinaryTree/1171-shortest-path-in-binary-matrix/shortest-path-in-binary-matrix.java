class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        Queue<Pair> queue = new LinkedList<>();
        int[][]dir = new int[][] {
            {0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}
        };
        queue.offer(new Pair(0,0));
        grid[0][0]=1;
        int count = 1;
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i=0;i<s;i++){
                Pair cur = queue.poll();
                if(cur.row == grid.length-1 && cur.col == grid[0].length-1){
                    return count;
                }
                
                for(int [] dire: dir){
                    int r = cur.row + dire[0];
                    int c = cur.col + dire[1];
                    if(r >= 0 && c >=0 && r < grid.length && c < grid[0].length && grid[r][c] == 0){
                        queue.offer(new Pair(r,c));
                        grid[r][c]=1;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
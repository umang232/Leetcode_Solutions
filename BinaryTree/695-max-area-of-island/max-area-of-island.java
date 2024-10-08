class Solution {
    public int maxAreaOfIsland(int[][] grid) {
     int count  = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    int num = dfs(i,j,grid);
                    count = Math.max(count,num);
                }
            }
        }
        return count;
    }
    private int dfs(int i,int j,int[][]grid){
        if(i<0 || j<0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        return (1+dfs(i+1,j,grid)+
        dfs(i-1,j,grid)+
        dfs(i,j+1,grid)+
        dfs(i,j-1,grid));
    }
}
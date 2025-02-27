class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j, new boolean[grid.length][grid[0].length]);
                } 
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 1; // Water contributes to perimeter
        }
        if (visited[i][j]) {
            return 0; // Already visited, don't count again
        }

        visited[i][j] = true;

        return dfs(grid, i, j + 1, visited) + 
               dfs(grid, i + 1, j, visited) + 
               dfs(grid, i, j - 1, visited) + 
               dfs(grid, i - 1, j, visited);
    }
}

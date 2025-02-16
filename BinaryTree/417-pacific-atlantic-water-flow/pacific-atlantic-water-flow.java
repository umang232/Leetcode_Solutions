class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                boolean[][] visitedPacific = new boolean[m][n];
                boolean[][] visitedAtlantic = new boolean[m][n];

                boolean pacific = isPacific(heights, i, j, visitedPacific);
                boolean atlantic = isAtlantic(heights, i, j, visitedAtlantic);
                if(pacific && atlantic){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

        public boolean isPacific(int[][] heights, int i, int j, boolean[][] visited) {
        if (i <= 0 || j <= 0) return true;  // Reached Pacific border
        if (visited[i][j]) return false; // Prevent infinite recursion
        
        visited[i][j] = true;

        // Check all four directions (only move if the next cell is lower or equal)
        if (i > 0 && heights[i - 1][j] <= heights[i][j] && isPacific(heights, i - 1, j, visited)) return true;
        if (j > 0 && heights[i][j - 1] <= heights[i][j] && isPacific(heights, i, j - 1, visited)) return true;
        if (i < heights.length - 1 && heights[i + 1][j] <= heights[i][j] && isPacific(heights, i + 1, j, visited)) return true;
        if (j < heights[0].length - 1 && heights[i][j + 1] <= heights[i][j] && isPacific(heights, i, j + 1, visited)) return true;

        return false;
    }

    public boolean isAtlantic(int[][] heights, int i, int j, boolean[][] visited) {
        if (i >= heights.length -1 || j >= heights[0].length-1) return true; // Reached Atlantic border
        if (visited[i][j]) return false; // Prevent infinite recursion

        visited[i][j] = true;

        // Check all four directions (only move if the next cell is lower or equal)
        if (i > 0 && heights[i - 1][j] <= heights[i][j] && isAtlantic(heights, i - 1, j, visited)) return true;
        if (j > 0 && heights[i][j - 1] <= heights[i][j] && isAtlantic(heights, i, j - 1, visited)) return true;
        if (i < heights.length - 1 && heights[i + 1][j] <= heights[i][j] && isAtlantic(heights, i + 1, j, visited)) return true;
        if (j < heights[0].length - 1 && heights[i][j + 1] <= heights[i][j] && isAtlantic(heights, i, j + 1, visited)) return true;

        return false;
    }

}
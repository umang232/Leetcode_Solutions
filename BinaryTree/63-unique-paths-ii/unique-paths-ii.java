class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][]dp = new int[r][c];
        if(obstacleGrid[r-1][c-1] == 1){
            dp[r-1][c-1] = 0;
        }
        else{
            dp[r-1][c-1] = 1;
        }
        for(int i= c-2; i>=0;i--){
            if(obstacleGrid[r-1][i] != 1){
                dp[r-1][i] = dp[r-1][i+1]; 
            }else{
                dp[r-1][i] = 0;
            }
        }
        for(int i= r-2; i>=0;i--){
            if(obstacleGrid[i][c-1] != 1){
                dp[i][c-1] = dp[i+1][c-1]; 
            }else{
                dp[i][c-1] = 0;
            }
        }
        for(int i=r-2;i>=0;i--){
            for(int j = c-2;j>=0;j--){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return dp[0][0];
    }
}
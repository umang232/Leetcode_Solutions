class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]dp = new int[m][n];
        if (obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Initialize the bottom-right corner
        dp[m-1][n-1] = 1;

        // Initialize the last row
        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m-1][i] == 1) {
                dp[m-1][i] = 0; // obstacle, no path
            } else {
                dp[m-1][i] = dp[m-1][i+1]; // inherit value from the right
            }
        }

        // Initialize the last column
        for (int i = m - 2; i >= 0; i--) {
            if (obstacleGrid[i][n-1] == 1) {
                dp[i][n-1] = 0; // obstacle, no path
            } else {
                dp[i][n-1] = dp[i+1][n-1]; // inherit value from the bottom
            }
        }

       for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // obstacle, no path
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1]; // sum from bottom and right
                }
            }
        }

        return dp[0][0]; // The top-left corner will have the answer
    }
}
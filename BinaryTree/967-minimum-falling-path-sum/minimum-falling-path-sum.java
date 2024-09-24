class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // If there is only one column, return the sum of the column
        if (n == 1) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += matrix[i][0];
            }
            return sum;
        }

        // Initialize dp array
        int[][] dp = new int[m][n];

        // Initialize the last row in dp with matrix values
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = matrix[m - 1][i];
        }

        // Process the matrix from second-last row to the top
        for (int i = m - 2; i >= 0; i--) {
            // First column
            dp[i][0] = matrix[i][0] + Math.min(dp[i + 1][0], dp[i + 1][1]);
            
            // Middle columns
            for (int j = 1; j < n - 1; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
            }

            // Last column
            dp[i][n - 1] = matrix[i][n - 1] + Math.min(dp[i + 1][n - 1], dp[i + 1][n - 2]);
        }

        // Find the minimum value in the first row
        int mini = dp[0][0];
        for (int i = 1; i < n; i++) {
            mini = Math.min(mini, dp[0][i]);
        }

        return mini;
    }
}

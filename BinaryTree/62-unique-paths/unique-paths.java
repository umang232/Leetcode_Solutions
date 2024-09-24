class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row: dp)
            Arrays.fill(row, 1);
        System.out.println(dp[0][0]);
        for(int i=m-2;i>=0;i--){
            for(int j = n-2;j>=0;j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1]; 
            }
        }
        return dp[0][0];
    }
}
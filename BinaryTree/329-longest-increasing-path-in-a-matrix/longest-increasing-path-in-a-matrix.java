class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][]dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                dp[i][j] = dfs(matrix,i,j,dp,-1);
            }
        }
        return Arrays.stream(dp)
                     .flatMapToInt(Arrays::stream)
                     .max()
                     .orElse(Integer.MIN_VALUE);
    }
    public int dfs(int[][] matrix,int i,int j,int[][]dp,int prev){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int res = 1;
        res = Math.max(res, 1 + dfs(matrix,i+1,j,dp,matrix[i][j]));
        res = Math.max(res, 1 + dfs(matrix,i-1,j,dp,matrix[i][j]));
        res = Math.max(res, 1 + dfs(matrix,i,j+1,dp,matrix[i][j]));
        res = Math.max(res, 1 + dfs(matrix,i,j-1,dp,matrix[i][j]));
        dp[i][j] = res;
        return res;
    }
}
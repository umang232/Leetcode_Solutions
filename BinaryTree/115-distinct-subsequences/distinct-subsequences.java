class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        
        // dp[i][j] represents the number of distinct subsequences of s[0..i-1] that equals t[0..j-1].
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: An empty t is a subsequence of any prefix of s.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // When s is empty (i=0) and t is non-empty, there are 0 subsequences.
        // dp[0][j] remains 0 for j >= 1 by default.
        
        // Build the dp table in a bottom-up manner.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current characters match, we have two choices:
                // 1. Use the matching character: dp[i-1][j-1]
                // 2. Skip the character in s: dp[i-1][j]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Else, skip the current character of s.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }

}
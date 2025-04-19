class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(coin <= i){
                    if(dp[i] == -1 && dp[i-coin] != -1){
                        dp[i] = 1 + dp[i-coin];
                    }else{
                        if(dp[i-coin] != -1) dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                    }
                }
            }
        }
        return dp[amount];
    }
}
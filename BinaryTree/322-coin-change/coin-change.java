class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);        
        dp[0] = 0;
        for(int i = 1;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j] == i) {
                    dp[i] = 1;
                }
                if(coins[j] < i){
                    if(dp[i-coins[j]] != Integer.MAX_VALUE){
                        dp[i] = Math.min(1+dp[i-coins[j]],dp[i]);
                    }
                }

            }
            System.out.println(dp[i]);
        }
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[amount];
        }
    }
}
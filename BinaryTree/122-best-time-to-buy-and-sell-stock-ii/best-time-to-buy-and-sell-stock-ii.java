class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int sell = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i] < sell){
                profit += (sell -buy);
                buy = prices[i];
                sell = prices[i];
            }else{
                sell = prices[i];
            }
        }
        profit += (sell-buy);
        return profit;
    }
}
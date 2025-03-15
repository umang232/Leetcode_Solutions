class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices= new int[n];
        for(int i = 0;i<n;i++){
            prices[i] = Integer.MAX_VALUE;
        }
        prices[src] = 0;
        for(int i=0;i<k+1;i++){
            int[] temp = Arrays.copyOf(prices, prices.length);
            for(int[]fl : flights){
                if(prices[fl[0]] == Integer.MAX_VALUE){
                    continue;
                }
                if(prices[fl[0]] + fl[2] < temp[fl[1]]){
                    temp[fl[1]] = prices[fl[0]] + fl[2];
                }
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
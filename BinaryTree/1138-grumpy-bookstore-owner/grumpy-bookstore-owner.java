class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int alwaysSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                alwaysSatisfied += customers[i];
            }
        }
        int extra = 0;
        for (int i = 0; i < minutes && i < n; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
        }
        int maxExtra = extra;
        for(int i=minutes;i<n;i++){
            if(grumpy[i] == 1){
                extra+=customers[i];
            }
            if(grumpy[i-minutes] == 1){
                extra-=customers[i-minutes];
            }
            maxExtra = Math.max(maxExtra,extra);
        }
        return maxExtra+alwaysSatisfied;
    }
}
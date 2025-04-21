class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for(int i=0;i<weights.length;i++){
            sum += weights[i];
            max = Math.max(max,weights[i]);
        }
        int left = max;
        int right = sum;
        while(left <= right){
            int mid = (left+right)/2;
            int d = findDays(weights,mid);
            if(d <= days){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public int findDays(int[] weights, int weightCap){
        int d = 0;
        int cur_sum = 0;
        for(int i=0;i<weights.length;i++){
            if(cur_sum + weights[i] > weightCap){
                d++;
                cur_sum = 0;
            }
            cur_sum += weights[i];
        }
        if(cur_sum <= weightCap){
            d++;
        }
        return d;
    }
}
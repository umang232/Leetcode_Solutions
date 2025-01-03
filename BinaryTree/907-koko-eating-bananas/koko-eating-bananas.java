class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int j = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>j){
                j = piles[i];
            }
        }
        int i = 1;
        while(i<j){
            int mid = (i+j)/2;
            int temp = 0;
            for(int k=0;k<piles.length;k++){
                temp += Math.ceil((double)piles[k] / mid);
            }
            if(temp<=h){
                j = mid;
            }else{
                i = mid+1;
            }
        }
        return i;
    }
}
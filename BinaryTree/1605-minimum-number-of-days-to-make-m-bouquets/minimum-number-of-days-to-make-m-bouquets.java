class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length){
            return -1;
        }
        int min =Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i])+1;
        }
        int cur = -1;
        while(min<=max){
            int mid = (min+max)/2;
            boolean ans = didBloom(bloomDay,m,k,mid);
            if(ans){
                cur = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return cur;
    }
    private boolean didBloom(int[]bd, int m, int k,int mid){
        int count = 0;
        int needed = m;
        for(int i=0;i<bd.length;i++){
            if(bd[i] <= mid){
                count ++;
                if(count == k){
                    needed --;
                    count = 0;
                }
                if(needed == 0){
                    return true;
                }
            }else{
                count = 0;
            }
        }
        return false;
    }
}
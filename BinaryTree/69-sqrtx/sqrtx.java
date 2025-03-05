class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while(l<=r){
            int m = l + (r-l)/2;
            if(m*m == x){
                return m;
            }else if((long) m*m > (long)x){
                r = m-1;
            }else{
                l =m+1;
            }
        }
        return Math.round(r);
    }
}
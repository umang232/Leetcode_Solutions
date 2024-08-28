class Solution {
    public int uniquePaths(int m, int n) {
        int[] r = new int[n];
        Arrays.fill(r,1);
        for(int j= 1;j<m;j++){
            int[] nr = new int[n];
            Arrays.fill(nr,1);
            for(int i= n-2;i>=0;i--){
                nr[i] = nr[i+1] + r[i];
            }
            r = nr;
        }
        return r[0];
    }
}
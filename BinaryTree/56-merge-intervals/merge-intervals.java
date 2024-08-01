class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int ans[][] = new int[intervals.length][2];
        int start = intervals[0][0];
        int end = intervals[0][1];
        int t = 0;
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] <= end){
                start = Math.min(start,intervals[i][0]);
                end = Math.max(end,intervals[i][1]);
            }else{
                ans[t][0] = start;
                ans[t][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                t++;
            }
        }
        ans[t][0] = start;
        ans[t][1] = end;
        int ret [][] = new int[t+1][2];
        for(int i=0;i<=t;i++){
            ret[i][0] = ans[i][0];
            ret[i][1] = ans [i][1];
        }
        return ret;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int prevEnd = intervals[0][1];
        int res = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= prevEnd){
                prevEnd = intervals[i][1];
            }else{
                res++;
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }
        }
        return res;
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int [][] jobs = new int[n][3];
        for(int i=0;i<n;i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(a-> a[1]));
        int dp[] = new int[n];
        dp[0] = jobs[0][2];
        for(int i=1;i<n;i++){
            int ipro = jobs[i][2];
            int l = 0, r =i-1, index = -1;
            while(l<=r){
                int mid = (l + r)/2;
                if(jobs[mid][1] <= jobs[i][0]){
                    l = mid+1;
                    index=mid;
                }else{
                    r = mid -1;
                }
            }
            if(index != -1){
                ipro += dp[index];
            }
            dp[i] = Math.max(dp[i-1], ipro);
        }
        return dp[n-1];
    }
}
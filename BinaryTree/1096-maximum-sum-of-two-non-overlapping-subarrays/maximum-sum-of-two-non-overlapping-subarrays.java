class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(helper(A, L, M), helper(A, M, L));
    }
    
    // Best total when X-length subarray precedes Y-length subarray
    private int helper(int[] A, int X, int Y) {
        int n = A.length;
        int sumX = 0, sumY = 0;
        // Initial sums for windows [0..X-1] and [X..X+Y-1]
        for (int i = 0; i < X; i++)        sumX += A[i];
        for (int i = X; i < X + Y; i++)    sumY += A[i];
        
        int bestX = sumX;
        int answer = bestX + sumY;
        
        // Slide both windows until the end of A
        for (int i = X + Y; i < n; i++) {
            // Move X-window right by 1 (now ends at i-Y)
            sumX += A[i - Y] - A[i - Y - X];
            bestX = Math.max(bestX, sumX);
            
            // Move Y-window right by 1 (ends at i)
            sumY += A[i] - A[i - Y];
            answer = Math.max(answer, bestX + sumY);
        }
        
        return answer;
    }
}

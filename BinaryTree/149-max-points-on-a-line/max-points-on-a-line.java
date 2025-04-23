import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int maxPoints = 0;

        for (int i = 0; i < n; i++) {
            Map<Double, Integer> slopeMap = new HashMap<>();
            int same = 1;
            int currMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    same++; // same point
                } else {
                    double slope;
                    if (dx == 0) {
                        slope = Double.POSITIVE_INFINITY;
                    } else {
                        slope = (double) dy / dx;

                        // Normalize -0.0 to 0.0
                        if (slope == -0.0) slope = 0.0;
                    }

                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                    currMax = Math.max(currMax, slopeMap.get(slope));
                }
            }

            maxPoints = Math.max(maxPoints, currMax + same);
        }

        return maxPoints;
    }
}

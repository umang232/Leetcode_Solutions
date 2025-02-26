class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] sortedQueries = new int[queries.length][2]; 
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        int[] result = new int[queries.length];
        Arrays.fill(result, -1); // Default value if no interval covers a query

        int i = 0; // Pointer for intervals
        for (int[] q : sortedQueries) {
            int query = q[0], queryIndex = q[1];

            // Add all intervals that start before or at the query
            while (i < intervals.length && intervals[i][0] <= query) {
                minHeap.offer(intervals[i]); // Add {start, end} to heap
                i++;
            }

            // Remove intervals that end before the query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            // If heap is not empty, the top element is the smallest interval covering the query
            if (!minHeap.isEmpty()) {
                int[] smallestInterval = minHeap.peek();
                result[queryIndex] = smallestInterval[1] - smallestInterval[0] + 1;
            }
        }
        return result;

    }
}
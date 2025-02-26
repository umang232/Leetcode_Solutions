class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Step 1: Initialize each node as its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Step 2: Process edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Find the root parents of both nodes
            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu == pv) {
                // Cycle detected! This is the redundant edge
                return edge;
            }

            // Union: Connect the nodes
            parent[pu] = pv;
        }
        
        return new int[0]; // Should never reach here
    }

    // Helper method to find root parent (with path compression)
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }
}

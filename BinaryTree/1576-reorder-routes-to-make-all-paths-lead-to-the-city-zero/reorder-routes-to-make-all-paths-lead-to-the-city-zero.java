class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer,List<int[]>>graph = new HashMap<>();
        for(int[] conn : connections){
            int from = conn[0];
            int to = conn[1];
            graph.computeIfAbsent(from, x-> new ArrayList<>()).add(new int[] {to, 1});
            graph.computeIfAbsent(to, x-> new ArrayList<>()).add(new int[] {from, 0});
        }
        boolean[] visited = new boolean[n];
        return dfs(0,graph,visited);
    }
    public int dfs(int node, Map<Integer,List<int[]>>graph, boolean[] visited){
        visited[node] = true;
        int count = 0;
        for(int [] nei : graph.getOrDefault(node, new ArrayList<>())){
            int adj = nei[0];
            int dir = nei[1];
            if(!visited[adj]){
                count+=dir;
                count+=dfs(adj,graph,visited);
            }
        }
        return count;
    }
}
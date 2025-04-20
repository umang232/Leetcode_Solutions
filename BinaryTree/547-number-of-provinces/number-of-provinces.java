class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjMatrix.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {     
                    adjMatrix.get(i).add(j);
                    adjMatrix.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(visited, i, adjMatrix);
                count++;
            }
            
        }
        return count;
    }

    private void dfs(boolean[] visited,int i,List<List<Integer>> adjMatrix){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        for(int nei : adjMatrix.get(i)){
            if(!visited[nei]){
                dfs(visited,nei,adjMatrix);
            }
        }
    }
}
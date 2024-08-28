class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(adj, visited, i)) {
                    return false;
                }
            }
        }
        return true;

    }
    private boolean isCyclic(List<List<Integer>> adj, int[] visited, int i){
        if(visited[i] == 2){
            return true;
        }
        visited[i] = 2;
        for(int j=0;j<adj.get(i).size();j++){
            if (visited[adj.get(i).get(j)] != 1) {
                if(isCyclic(adj,visited,adj.get(i).get(j))){
                    return true;
                }
            }
        }
        visited[i] = 1;
        return false;
    }
}
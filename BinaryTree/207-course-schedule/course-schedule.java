class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int next :adj[course]){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }   
}
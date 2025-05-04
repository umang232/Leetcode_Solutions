class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
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
            for(int next :adj.get(course)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }   
}
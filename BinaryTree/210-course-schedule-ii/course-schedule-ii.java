class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1){
            return new int[] {0};
        }
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i =0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }

        int indegree[] = new int[numCourses];

        for(int pre[] : prerequisites){
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }
        int result[] = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int j=0;
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i=0;i<s;i++){
                int course = queue.poll();
                result[j] = course;
                j++;
                for(Integer dependency : adj[course]){
                    indegree[dependency]--;
                    if(indegree[dependency] == 0){
                        queue.offer(dependency);
                    }
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i] > 0){
                return new int[] {};
            }
        }
        return result;

    }
}
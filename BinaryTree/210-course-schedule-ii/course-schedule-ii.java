class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1){
            return new int[] {0};
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int pre[] :prerequisites){
            adjList.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        int[] result = new int[numCourses];
        int j = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int course = queue.poll();
                result[j] = course;
                j++;
                for(int nei: adjList.get(course)){
                    if(indegree[nei] > 0){
                        indegree[nei]--;
                        if(indegree[nei] == 0){
                            queue.offer(nei);
                        }
                    }
                }
            }
        }
        for(int k = 0;k<numCourses;k++){
            if(indegree[k] > 0){
                return new int[] {};
            }
        }
        return result;
    }
}
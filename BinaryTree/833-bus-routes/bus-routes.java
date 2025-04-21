class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for(int bus=0;bus<routes.length;bus++){
            for(int stop: routes[bus]){
                stopToBuses.computeIfAbsent(stop, x-> new ArrayList<>()).add(bus);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        int buses = 0;
        q.offer(source);
        visitedStops.add(source);
        while(!q.isEmpty()){
            int s = q.size();
            buses++;
            for(int i=0;i<s;i++){
                int cur_stop = q.poll();
                List<Integer> busesThroughStops = stopToBuses.getOrDefault(cur_stop, new ArrayList<>());
                for(int bus: busesThroughStops){
                    if(visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);
                    for(int stop: routes[bus]){
                        if(stop == target){
                            return buses;
                        }
                        if(visitedStops.contains(stop)) continue;
                        visitedStops.add(stop);
                        q.offer(stop);
                    }
                }
            }
        }
        return -1;
    }
}
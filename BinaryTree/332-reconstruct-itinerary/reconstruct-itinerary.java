class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Graph representation using adjacency list with a min-heap (PriorityQueue)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        // Build the graph
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        List<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        
        // Since DFS adds nodes in reverse order, we reverse it at the end
        return itinerary;
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(node);
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), graph, itinerary);
        }
        itinerary.add(0, node);  // Add nodes in reverse order (linked list efficient for adding at head)
    }
    
}
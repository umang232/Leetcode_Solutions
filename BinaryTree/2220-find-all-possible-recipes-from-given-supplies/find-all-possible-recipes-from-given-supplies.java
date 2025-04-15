

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>(); // ingredient -> list of recipes dependent on it
        Map<String, Integer> indegree = new HashMap<>(); // recipe -> number of ingredients it needs
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        // Initialize graph and indegree
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Queue for BFS
        Queue<String> queue = new LinkedList<>(supplySet);

        while (!queue.isEmpty()) {
            String item = queue.poll();

            if (!graph.containsKey(item)) continue;

            for (String recipe : graph.get(item)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    result.add(recipe);
                    queue.offer(recipe);
                }
            }
        }

        return result;
    }
}

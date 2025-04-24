/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = mapParents(root, null, parentMap, start);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);
        visited.add(startNode);

        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode neighbor : Arrays.asList(node.left, node.right, parentMap.get(node))) {
                    if (neighbor != null && visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return time;
    }

    private TreeNode mapParents(TreeNode node, TreeNode parent,
                                Map<TreeNode, TreeNode> map, int start) {
        if (node == null) return null;
        map.put(node, parent);
        if (node.val == start) return node;
        TreeNode left = mapParents(node.left, node, map, start);
        if (left != null) return left;
        return mapParents(node.right, node, map, start);
    }
}

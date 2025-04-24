class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    // returns [maxIfNotRobbed, maxIfRobbed]
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // If we rob this node, we can't rob children
        int rob = node.val + left[0] + right[0];

        // If we don't rob this node, we take max of robbing or not robbing children
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{notRob, rob};
    }
}

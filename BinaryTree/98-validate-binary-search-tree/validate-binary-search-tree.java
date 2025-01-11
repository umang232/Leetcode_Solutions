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
    public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
}

private boolean isValidBST(TreeNode node, Integer min, Integer max) {
    if (node == null) {
        return true;
    }
    // Check if the current node violates the BST property
    if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
        return false;
    }
    // Recursively validate the left and right subtrees with updated ranges
    return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
}

}
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
    int maxV = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dia(root);
        return maxV;
    }
    public int dia(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dia(root.left);
        int r = dia(root.right);
        maxV = Math.max(maxV,l+r);
        return 1+ Math.max(l,r);
    }
}
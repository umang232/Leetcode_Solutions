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
    int dif = 0;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        height(root);
        System.out.println(dif);
        if(dif > 1){
            return false;
        }else{
            return true;
        }
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        dif = Math.max(dif,Math.abs(left-right));
        return 1 + Math.max(left,right);
    }
}
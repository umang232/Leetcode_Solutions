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
    public int goodNodes(TreeNode root) {
        return count(root,root.val);
    }
    public int count(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        else if(root.val >= max){
            return 1 + (count(root.left,Math.max(max,root.val)) + count(root.right,Math.max(max,root.val)));
        }else{
            return (count(root.left,Math.max(max,root.val)) + count(root.right,Math.max(max,root.val)));
        }
    }
}
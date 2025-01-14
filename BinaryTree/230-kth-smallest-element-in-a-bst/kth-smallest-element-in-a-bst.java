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
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        travserse(root,k);
        return result;
    }
    public void travserse(TreeNode root, int k){
        if(root == null){
            return;
        }
        travserse(root.left,k);
        count ++;
        if(count == k){
            result = root.val;
        }
        travserse(root.right,k);
    }
}
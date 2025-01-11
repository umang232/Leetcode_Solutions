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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int i = 0;
            while(i!=s){
                TreeNode v = q.poll();
                if(i == s-1){
                    ans.add(v.val);
                }
                if(v.left!=null){
                    q.add(v.left);
                }
                if(v.right != null){
                    q.add(v.right);
                }
                i++;
            }
        }
        return ans;
    }
}
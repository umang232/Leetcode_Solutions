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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            List<List<Integer>> arr = new ArrayList<>();
            return arr;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> temp;
        while(!q.isEmpty()){
            int s = q.size();
            int i = 0;
            temp = new ArrayList<Integer>();
            while(i!=s){
                TreeNode v = q.poll();
                temp.add(v.val);
                if(v.left!=null){
                    q.add(v.left);
                }
                if(v.right != null){
                    q.add(v.right);
                }
                
                i++;
            }
            ans.add(temp);
        }
        return ans;
    }

}
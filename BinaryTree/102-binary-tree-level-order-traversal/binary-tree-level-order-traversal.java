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
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int len = queue.size();
            for(int i =0;i<len;i++){
                if(queue.peek().left !=null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right !=null){
                    queue.add(queue.peek().right);
                }
                temp.add(queue.peek().val);
                queue.remove();
            }
            ans.add(temp);
        }
        return ans;
    }
}
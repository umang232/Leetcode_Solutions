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
    private int preorderIndex = 0;
    private HashMap<Integer,Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return construct(preorder,0,inorder.length-1);
    }
    private TreeNode construct(int[] preorder, int s, int e){
        if(s>e){
            return null;
        }
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderMap.get(rootVal);
        root.left = construct(preorder,s,index-1);
        root.right = construct(preorder,index+1,e);
        return root;
    }
}
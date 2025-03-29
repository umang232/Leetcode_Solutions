import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !st.isEmpty()) {
            while (cur != null) {  // Go to the leftmost node
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop(); // Process node
            result.add(cur.val);
            cur = cur.right; // Move to right subtree
        }
        return result;
    }
}

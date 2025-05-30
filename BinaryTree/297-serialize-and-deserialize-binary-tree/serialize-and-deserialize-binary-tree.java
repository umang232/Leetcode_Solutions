/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "n";
        }
        return "" + root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return build (new Scanner(data));
    }
    private TreeNode build(Scanner sc){
        if(!sc.hasNext()){
            return null;
        }
        String tk = sc.next();
        if(tk.equals("n")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tk));
        root.left = build(sc);
        root.right = build(sc);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
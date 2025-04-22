/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        if(root == null){
            return root;
        }
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i=0;i<s;i++){
                Node cur = queue.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
                if(i!=s-1){
                    cur.next = queue.peek();
                }
            }
        }
        return root;
    }
}
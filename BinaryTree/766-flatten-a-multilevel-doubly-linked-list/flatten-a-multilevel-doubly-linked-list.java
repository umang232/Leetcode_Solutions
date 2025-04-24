class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        flattenDFS(head);
        return head;
    }

    // Returns the tail of the flattened list
    private Node flattenDFS(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            // If there's a child, recursively flatten it
            if (curr.child != null) {
                Node childTail = flattenDFS(curr.child);

                // Connect curr to child
                curr.next = curr.child;
                curr.child.prev = curr;

                // Connect child's tail to next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                curr.child = null;
                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}

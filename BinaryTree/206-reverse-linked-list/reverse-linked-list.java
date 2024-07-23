/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;;
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode n = head;
        while(n != null){
            ListNode cu = n.next;
            n.next = temp;
            temp = n;
            n = cu;
        }
        return temp;
        }
}
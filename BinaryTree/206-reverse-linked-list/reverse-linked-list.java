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
        if(head == null){
            return null;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp.next!=null){
            ListNode n = temp.next;
            temp.next = prev;
            prev = temp;
            temp = n;
        }
        temp.next = prev;
        return temp;

    }
}
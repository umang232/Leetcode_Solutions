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
    public void reorderList(ListNode head) {
        if(head ==null ||head.next == null || head.next.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        ListNode prev = null, cur = slow.next;
        slow.next = null;

        while(cur!=null){
            ListNode nn = cur.next;
            cur.next = prev;
            prev = cur;
            cur= nn;
        }

        ListNode f =head;
        ListNode s= prev;
        while(s!=null){
            ListNode fn = f.next;
            ListNode sn = s.next;
            f.next = s;
            s.next = fn;
            f = fn;
            s= sn;
        }
    }
}
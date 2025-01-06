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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode ans = slow;
        int i = 0;
        if(head == null){
            return null;
        }
        if(head.next == null && n == 1){
            return null;
        }
        while(i!=n){
            fast= fast.next;
            i++;
        }
        if(fast == null){
            return ans.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return ans;
    }
}
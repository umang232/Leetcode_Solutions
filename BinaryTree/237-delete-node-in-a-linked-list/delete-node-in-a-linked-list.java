/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode prev = null;
        while(temp.next != null){
            ListNode n = temp.next;
            int val = temp.val;
            temp.val = n.val;
            n.val = val;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        
    }
}
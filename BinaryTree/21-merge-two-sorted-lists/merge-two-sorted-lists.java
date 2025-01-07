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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode temp3 = null;
        if(temp1.val < temp2.val){
            temp3 = temp1;
            temp1 = temp1.next;
        }
        else{
            temp3 = temp2;
            temp2 = temp2.next;
        }
       ListNode ret = temp3; 
        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                temp3.next = temp1;
                temp1 = temp1.next;
            }else{
                temp3.next = temp2;
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }
        while(temp1!=null){
            temp3.next = temp1;
            temp1 = temp1.next;
            temp3 = temp3.next;
        }
        while(temp2!=null){
            temp3.next = temp2;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }
        return ret;
    }
}
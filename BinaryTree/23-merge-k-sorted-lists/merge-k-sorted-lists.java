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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        while(lists.length > 1){
            List<ListNode> temp = new ArrayList<>();
            for(int i=0;i<lists.length;i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = i+1 < lists.length? lists[i+1] : null;
                temp.add(mergeTwoLists(l1,l2));
            }
            lists = temp.toArray(new ListNode[0]);
        }
        return lists[0];
        
    }
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
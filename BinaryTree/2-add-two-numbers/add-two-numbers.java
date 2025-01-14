class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry= 0;
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        while(l1!=null && l2!=null){
            int val = l1.val+l2.val+carry;
            if(val > 9){
                val = val%10;
                carry = 1;
            }else{
                carry = 0;
            }
            ListNode dum = new ListNode(val);
            temp.next = dum;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int val = l1.val+carry;
            if(val > 9){
                val = val%10;
                carry = 1;
            }else{
                carry = 0;
            }
            ListNode dum = new ListNode(val);
            temp.next = dum;
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int val = l2.val+carry;
            if(val > 9){
                val = val%10;
                carry = 1;
            }else{
                carry = 0;
            }
            ListNode dum = new ListNode(val);
            temp.next = dum;
            temp = temp.next;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode dum = new ListNode(1);
            temp.next = dum;
            temp = temp.next;
        }
        return ans.next;
    }
}
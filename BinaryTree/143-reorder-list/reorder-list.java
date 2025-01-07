public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode prev = null, curr = slow.next;
        slow.next = null; // Split the list into two halves
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Step 3: Merge the two halves
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Odd Length
        ListNode oddHead = new ListNode(1);
        oddHead.next = new ListNode(2);
        oddHead.next.next = new ListNode(3);
        oddHead.next.next.next = new ListNode(4);
        oddHead.next.next.next.next = new ListNode(5);
        solution.reorderList(oddHead);
        printList(oddHead); // Expected: 1 -> 5 -> 2 -> 4 -> 3 -> null

        // Even Length
        ListNode evenHead = new ListNode(1);
        evenHead.next = new ListNode(2);
        evenHead.next.next = new ListNode(3);
        evenHead.next.next.next = new ListNode(4);
        solution.reorderList(evenHead);
        printList(evenHead); // Expected: 1 -> 4 -> 2 -> 3 -> null
    }
}

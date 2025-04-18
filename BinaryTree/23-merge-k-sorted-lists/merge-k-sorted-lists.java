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
        if (lists == null || lists.length == 0) return null;

        // Iteratively reduce the list count by merging in pairs
        while (lists.length > 1) {
            List<ListNode> merged = new ArrayList<>();

            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i + 1] : null;
                merged.add(mergeTwoLists(l1, l2));
            }

            // Convert back to array for the next round
            lists = merged.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach the remaining list
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}

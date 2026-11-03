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
        int len = 0;
        ListNode newCurr = new ListNode(-1);
        newCurr.next = head;
        ListNode curr = newCurr;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        curr = newCurr;
        while (len - n - 1 > 0) {
            curr = curr.next;
            len--;
        }

        ListNode next = curr.next.next;
        curr.next = next;

        return newCurr.next;
    }
}

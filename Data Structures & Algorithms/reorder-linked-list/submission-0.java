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

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp; 
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode curr = head;
        while(curr.next != null){
            ListNode reversed = reverse(curr.next);
            curr.next = reversed;
            curr = curr.next;
        }
    }
}

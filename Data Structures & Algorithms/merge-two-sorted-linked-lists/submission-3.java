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
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1 == null && list2 == null) {
            return list1;
        }
        if (list2.val < list1.val) {
            return mergeTwoLists(list2, list1);
        }
        ListNode it1 = list1, it2 = list2;
        while (it1.next != null && it2 != null) {
            ListNode next = it1.next;
            if (it1.val <= it2.val && it2.val <= next.val) {
                ListNode temp = it2.next;
                it2.next = it1.next;
                it1.next = it2;
                it2 = temp;
            }

            it1 = it1.next;
        }

        if (it1.next == null) {
            it1.next = it2;
        }

        return list1;
    }
}
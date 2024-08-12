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
    public void reorderList(ListNode head) {
        ListNode copyHead = new ListNode(head.val, null);
        ListNode copyCursor = copyHead;
        ListNode cursor = head;
        int size = 1;

        // copy list O(n)
        while (cursor.next != null) {
            cursor = cursor.next;
            copyCursor.next = new ListNode(cursor.val, null);
            copyCursor = copyCursor.next;
            size++;
        }

        if (size == 1) return;

        // reverse O(n)
        ListNode newCopyHead = null;
        while (copyHead != null) {
            ListNode next = copyHead.next;
            copyHead.next = newCopyHead;
            newCopyHead = copyHead;
            copyHead = next;
        }

        // cross link O(n)
        cursor = head;
        ListNode next = cursor.next;
        cursor.next = newCopyHead;
        cursor = cursor.next;
        for (int i = 0; i < size-2; i++) {
            ListNode temp = next;
            next = cursor.next;
            cursor.next = temp;

            cursor = cursor.next;
        }

        cursor.next = null;
    }
}
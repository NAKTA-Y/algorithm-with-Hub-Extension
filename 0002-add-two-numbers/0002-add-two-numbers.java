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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        add(l1, l2, root, 0);
        return root;
    }

    public void add(ListNode l1, ListNode l2, ListNode node, int carry) {
        int val1 = (l1 == null) ? 0 : l1.val;
        int val2 = (l2 == null) ? 0 : l2.val;
        ListNode next1 = (l1 == null) ? null : l1.next;
        ListNode next2 = (l2 == null) ? null : l2.next;

        int result = val1 + val2 + carry;
        node.val = result % 10;
        carry = result / 10;

        if (next1 == null && next2 == null) {
            if (carry != 0)  node.next = new ListNode(carry);
            return;
        }

        node.next = new ListNode(-1);

        add(next1, next2, node.next, carry);
    }
}
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
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (len == n) return head.next;

        ListNode dummy = new ListNode(0), pre = dummy;
        cur = head;
        int m = len - n;
        while (m > 0) {
            pre = cur;
            cur = cur.next;
            m--;
        }

        pre.next = cur.next;
        return head;
    }
}
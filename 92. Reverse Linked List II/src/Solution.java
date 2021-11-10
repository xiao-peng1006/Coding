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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode cur = head, pre = null;
        while (left > 1) {
            pre = cur;
            cur = cur.next;
            left--;
            right--;
        }

        ListNode con = pre, tail = cur;
        ListNode next = null;
        while (right > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            right--;
        }

        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }

        tail.next = cur;
        return head;
    }
}
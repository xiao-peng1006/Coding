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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head.next, pre = head;
        int num = head.val;

        while (cur != null) {
            if (cur.val == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
                num = pre.val;
            }
            cur = cur.next;

        }
        return head;
    }
}
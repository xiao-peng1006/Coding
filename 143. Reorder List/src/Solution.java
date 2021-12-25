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
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }

        ListNode secondHead = slow;
        ListNode cur = head, secondCur = reverse(secondHead);

        while (secondCur.next != null) {
            ListNode next = cur.next;
            cur.next = secondCur;
            cur = next;

            next = secondCur.next;
            secondCur.next = cur;
            secondCur = next;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = null;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
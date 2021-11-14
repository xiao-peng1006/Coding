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
    public ListNode oddEvenList(ListNode head) {
        ListNode cur = head, oddCur = head;
        boolean isOdd = true;
        Queue<Integer> q = new LinkedList<>();
        while (cur != null) {
            if (isOdd) {
                oddCur.val = cur.val;
                oddCur = oddCur.next;
            } else {
                q.add(cur.val);
            }
            cur = cur.next;
            isOdd = !isOdd;
        }

        ListNode evenCur = oddCur;
        while (!q.isEmpty()) {
            evenCur.val = q.poll();
            evenCur = evenCur.next;
        }
        return head;
    }
}
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
    List<ListNode> list;
    int size = 0;
    Random r =  new Random();

    public Solution(ListNode head) {
        this.list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            this.list.add(cur);
            cur = cur.next;
            size++;
        }
    }

    public int getRandom() {
        int index = r.nextInt(size);
        return this.list.get(index).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
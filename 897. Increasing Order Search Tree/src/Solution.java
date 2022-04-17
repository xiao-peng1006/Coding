/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);

        TreeNode head = new TreeNode(-1);
        TreeNode cur = head;
        for (int i = 0; i < ans.size(); i++) {
            cur.right = new TreeNode(ans.get(i));
            cur = cur.right;
        }
        return head.right;
    }


    public void inOrder(TreeNode node, List<Integer> ans) {
        if (node == null) return;

        inOrder(node.left, ans);
        ans.add(node.val);
        inOrder(node.right, ans);
    }
}
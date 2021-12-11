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
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        this.ans = new ArrayList<>();
        inOrder(root);
        return ans;
    }

    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        this.ans.add(node.val);
        inOrder(node.right);
    }
}
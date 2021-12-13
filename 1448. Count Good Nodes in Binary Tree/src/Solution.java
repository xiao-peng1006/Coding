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
    int ans;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return ans;
    }

    public void helper(TreeNode node, int prev) {
        if (node == null) {
            return;
        }

        if (node.val >= prev) {
            ans++;
        }

        if (node.val > prev) {
            prev = node.val;
        }

        helper(node.left, prev);
        helper(node.right, prev);
    }
}
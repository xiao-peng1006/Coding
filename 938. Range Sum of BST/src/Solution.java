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
    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        helper(root, low, high);
        return ans;
    }

    public void helper(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }

        if (node.val <= high && node.val >= low) {
            this.ans += node.val;
        }

        if (node.val > low) {
            helper(node.left, low, high);
        }

        if (node.val < high) {
            helper(node.right, low, high);
        }
    }
}
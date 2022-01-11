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
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int num) {
        if (node != null) {
            num = num*2 + node.val;
            if (node.left == null && node.right == null) {
                ans += num;
            }
            dfs(node.left, num);
            dfs(node.right, num);
        }
    }
}
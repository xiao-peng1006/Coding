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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayDeque<TreeNode> nextLevel = new ArrayDeque() {{ offer(root); }};
        ArrayDeque<TreeNode> curLevel = new ArrayDeque();

        List<Integer> ans = new ArrayList<>();

        TreeNode node = null;
        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            curLevel = nextLevel.clone();
            nextLevel.clear();

            // add child nodes of the current level
            // in the queue for the next level
            while (!curLevel.isEmpty()) {
                node = curLevel.poll();

                if (node.left != null) {
                    nextLevel.offer(node.left);
                }

                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }

            // The current level is finished.
            // Its last element is the rightmost one.
            if (curLevel.isEmpty()) {
                ans.add(node.val);
            }
        }
        return ans;
    }
}
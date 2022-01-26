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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        Stream.of(inorder(root1, new ArrayList()), inorder(root2, new ArrayList())).forEach(ans::addAll);
        Collections.sort(ans);
        return ans;
    }

    public List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return arr;
        }

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
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
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] swapped = findTwoSwappedNodes(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    public int[] findTwoSwappedNodes(List<Integer> nums) {
        int x = -1, y = -1;
        int n = nums.size();
        boolean swapped_first_occurrence = false;

        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i+1);
                // x = nums.get(i);
                // break;
                if (!swapped_first_occurrence) {
                    x = nums.get(i);
                    swapped_first_occurrence = true;
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) return;
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }
}
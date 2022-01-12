class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;

        if (k == 0) return;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(nums[len - i - 1]);
        }

        for (int i = len - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = stack.pop();
        }
    }
}
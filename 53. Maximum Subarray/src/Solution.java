class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            current = Math.max(num, current + num);
            max = Math.max(current, max);
        }
        return max;
    }
}
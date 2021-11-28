class Solution {
    public int climbStairs(int n) {
        return helper(0, n);
    }

    public int helper(int i, int n) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }
        return helper(i + 1, n) + helper(i + 2, n);
    }
}
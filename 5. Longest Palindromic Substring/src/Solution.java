class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] longest = new int[]{0,0};

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i + 1 < n; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i+1]) {
                longest[0] = i;
                longest[1] = i + 1;
            }
        }

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                dp[i][i+gap] = dp[i+1][i+gap-1] && s.charAt(i) == s.charAt(i+gap);
                if (dp[i][i+gap] && (longest[1] - longest[0] + 1 < gap + 1)) {
                    longest[0] = i;
                    longest[1] = i+gap;
                }
            }
        }

        return s.substring(longest[0], longest[1]+1);
    }
}
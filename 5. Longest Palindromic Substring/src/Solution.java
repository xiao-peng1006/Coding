class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int len = ans.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && (j - i) > len) {
                    ans = sub;
                    len = j - i;
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++; end--;
        }
        return true;
    }
}
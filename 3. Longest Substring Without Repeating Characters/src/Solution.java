class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;

        while (end < s.length() && start <= end ) {
            char c = s.charAt(end);
            if (set.contains(c)) {
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(c);
                ans = Math.max(ans, end - start + 1);
            }
            end++;
        }
        return ans;
    }
}
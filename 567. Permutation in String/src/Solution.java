class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int n = s1.length();
        int start = 0, end = n - 1;
        int[] target = new int[26];
        int[] current = new int[26];
        for (int i = 0; i < n; i++) {
            target[s1.charAt(i) - 'a']++;
            current[s2.charAt(i) - 'a']++;
        }

        if (Arrays.compare(target, current) == 0) {
            return true;
        }

        for (int i = end + 1; i < s2.length(); i++) {
            current[s2.charAt(i) - 'a']++;
            current[s2.charAt(i - end - 1) - 'a']--;

            if (Arrays.compare(target, current) == 0) {
                return true;
            }
        }
        return false;
    }
}
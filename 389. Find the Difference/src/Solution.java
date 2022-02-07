class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        int slen = s.length(), tlen = t.length();
        for (int i = 0; i < slen; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < tlen; i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return (char) (i + 'a');
            }
        }

        return ' ';
    }
}
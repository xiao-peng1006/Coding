class Solution {
    public int titleToNumber(String columnTitle) {
        if (columnTitle.length() == 0) return 0;

        int ans = 0, count = 0;
        for (int i = columnTitle.length() - 1; i >= 0 ; i--) {
            char c = columnTitle.charAt(i);
            ans += (c - 'A' + 1)*(Math.pow(26, count));
            count++;
        }

        return ans;
    }
}
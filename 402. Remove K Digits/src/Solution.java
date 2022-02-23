class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return String.valueOf(0);
        }

        int len = num.length();

        Integer min = String.valueOf(num);
        for (int i = 0; i < len - k + 1; i++) {
            String newStr = num.substring(0, i) + num.substring(i, len);
            int newNum = Integer.parseInt(newStr);

            min = Math.min(min, newNum);
        }

        return String.valueOf(min);
    }
}
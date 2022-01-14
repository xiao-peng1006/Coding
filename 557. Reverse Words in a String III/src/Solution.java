class Solution {
    public String reverseWords(String s) {
        String[] strArray = s.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = reverse(strArray[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
            sb.append(" ");
        }

        String ans = sb.toString();
        return ans.substring(0, ans.length() - 1);


    }

    String reverse(String s) {
        char[] cArray = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char temp = cArray[left];
            cArray[left] = cArray[right];
            cArray[right] = temp;
            left++; right--;
        }
        return String.valueOf(cArray);
    }
}
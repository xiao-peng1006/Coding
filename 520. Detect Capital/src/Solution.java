class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0, firstCap = word.length();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitals++;
                firstCap = Math.min(firstCap, i);
            }
        }

        if (capitals == word.length() || capitals == 0) {
            return true;
        } else if (capitals == 1 && firstCap == 0) {
            return true;
        }

        return false;
    }
}
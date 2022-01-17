class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if (sArray.length != pattern.length()) {
            return false;
        }

        Map<Character, String> patToStr = new HashMap<>();
        Map<String, Character> strToPat = new HashMap<>();

        for (int i = 0; i < sArray.length; i++) {
            Character c = pattern.charAt(i);
            String str = sArray[i];

            if (patToStr.containsKey(c)) {
                if (!str.equals(patToStr.get(c))) {
                    return false;
                }
            } else {
                if (strToPat.containsKey(str)) {
                    return false;
                }
                patToStr.put(c, str);
                strToPat.put(str, c);
            }
        }
        return true;
    }
}
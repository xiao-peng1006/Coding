class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> uniqueCharactersInStr2 = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
                uniqueCharactersInStr2.add(c2);
            }
        }

        if (uniqueCharactersInStr2.size() < 26) {
            return true;
        }

        return false;
    }
}
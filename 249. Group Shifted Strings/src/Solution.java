class Solution {
    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> map = new HashMap();

        for (String str:strings) {
            String hashKey = getHash(str);
            if (map.get(hashKey) == null) {
                map.put(hashKey, new ArrayList<>());
            }
            map.get(hashKey).add(str);
        }

        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : map.values()) {
            groups.add(group);
        }

        return groups;

    }

    public String getHash(String s) {
        char[] chars = s.toCharArray();

        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }

        String hashKey = String.valueOf(chars);
        return hashKey;
    }

    public char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }
}
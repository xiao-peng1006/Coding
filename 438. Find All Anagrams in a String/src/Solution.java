class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList();
        }

        Map<Character, Integer> sCount = new HashMap();
        Map<Character, Integer> pCount = new HashMap();

        for (int i = 0; i < pLen; i++) {
            char c = p.charAt(i);
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        List<Integer> ans = new ArrayList();
        for(int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            sCount.put(c, sCount.getOrDefault(c, 0) +1);

            if (i >= pLen) {
                c = s.charAt(i - pLen);
                if (sCount.get(c) == 1) {
                    sCount.remove(c);
                } else {
                    sCount.put(c, sCount.get(c) - 1);
                }
            }

            if (pCount.equals(sCount)) {
                ans.add(i - pLen + 1);
            }
        }

        return ans;
    }
}
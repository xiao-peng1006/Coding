class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(String s, int start, List<String> list) {
        if (start >= s.length()) {
            this.ans.add(new ArrayList<>(list));
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {
                list.add(s.substring(start, end+1));
                dfs(s, end + 1, list);
                list.remove(list.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++; right--;
        }
        return true;
    }
}
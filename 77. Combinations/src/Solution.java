class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        this.ans = new ArrayList<>();
        helper(n, k, 1, new ArrayList<Integer>());
        return ans;
    }

    void helper(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            this.ans.add(new ArrayList(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
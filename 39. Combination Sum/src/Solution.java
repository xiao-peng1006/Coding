class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        helper(candidates, 0, target, new LinkedList<>());
        return ans;
    }

    public void helper(int[] candidates, int start, int target, LinkedList<Integer> list) {
        if (target == 0) {
            this.ans.add(new ArrayList<>(list));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, i, target - candidates[i], list);
            list.removeLast();
        }
    }
}
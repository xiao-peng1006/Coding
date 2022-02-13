class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> subsets = new ArrayList<>();

            for (List<Integer> list : ans) {
                subsets.add(new ArrayList<Integer>(list){{add(num);}});
            }

            for (List<Integer> subset : subsets) {
                ans.add(subset);
            }
        }
        return ans;
    }
}
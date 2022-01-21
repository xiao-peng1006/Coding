class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        backtrack(nums, 0);
        return this.ans;
    }

    void backtrack(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            this.ans.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++){
            swap(nums, start, i);
            backtrack(nums, start+1);
            swap(nums, i, start);
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;

        Arrays.sort(nums);
        int left, right, target;
        List<Integer> list;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    list = Arrays.asList(nums[i], nums[left], nums[right]);
                    if (!ans.contains(list)) {
                        ans.add(list);
                    }
                    left++;
                }
            }
        }
        return ans;
    }
}
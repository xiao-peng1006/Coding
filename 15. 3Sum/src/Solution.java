class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[low] + nums[high] + nums[i];
                    if (sum < 0) {
                        low++;
                    } else if (sum > 0) {
                        high--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                        while (low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
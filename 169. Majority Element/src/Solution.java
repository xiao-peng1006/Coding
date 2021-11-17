class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length/2;
        for (int num : nums) {
            if (map.containsKey(num) && (map.get(num) + 1) > len) {
                return num;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return 0;
    }
}
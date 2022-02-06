class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int idx = 0, curIdx = 0;
        while (curIdx < nums.length) {
            int curNum = nums[curIdx];
            if (!count.containsKey(curNum) || count.get(curNum) < 2) {
                count.put(curNum, count.getOrDefault(curNum, 0) + 1);
                nums[idx++] = curNum;
            }
            curIdx++;
        }
        return idx;
    }
}
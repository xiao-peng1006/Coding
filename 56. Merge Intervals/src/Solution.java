class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int left = 0, right = 1;
        int next = 1;
        while (right < intervals.length) {
            if (intervals[left][1] >= intervals[right][0]) {
                intervals[left][1] = intervals[right][1] > intervals[left][1] ? intervals[right][1] : intervals[left][1];
                right++;
            } else {
                intervals[next++] = intervals[right];
                left++;
                right++;
            }
        }

        int[][] ans = new int[next][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = intervals[i];
        }

        return ans;
    }
}
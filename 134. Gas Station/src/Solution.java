class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int len = gas.length;
        int[] ans = new int[len];
        for (int start = 0; start < len; start++) {
            for (int cur = start; cur < start + len; cur++) {
                int idx = cur%len;
                tank += gas[idx];
                if (tank < cost[idx]) {
                    ans[start] = -1;
                    continue;
                }
                tank -= cost[idx];
            }
            ans[start] = ans[start] == -1 ? -1 : tank;
            tank = 0;
        }

        for (int i = 0; i < len; i++) {
            if (ans[i] >= 0) {
                return i;
            }
        }

        return -1;
    }
}
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] reminders = new int[60];
        int count = 0;

        for (int t : time) {
            if (t%60 == 0) {
                count += reminders[0];
            } else {
                count += reminders[60 - t%60];
            }
            reminders[t%60]++;
        }
        return count;
    }
}
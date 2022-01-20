class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int hours = 0;
        while (min < max) {
            int mid = (max + min) / 2;
            for (int pile : piles) {
                hours += Math.ceil((double) pile/mid);
            }

            if (hours <= h) {
                max = mid;
            } else {
                min = mid + 1;
            }
            hours = 0;
        }
        return max;
    }
}
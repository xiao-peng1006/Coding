class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int stops = 0;
        for (int[] trip:trips) {
            stops = Math.max(stops, trip[2]);
        }

        int[] numOfPassengers = new int[stops];

        for (int[] trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                numOfPassengers[i] += trip[0];
            }
        }

        for (int n : numOfPassengers) {
            if (n > capacity) {
                return false;
            }
        }
        return true;
    }
}
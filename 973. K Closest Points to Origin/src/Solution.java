class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points.length == 0 || k > points.length) return points;
        if (k == 0) return new int[][]{};

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((pointOne, pointTwo) -> {
            return (pointOne[0]*pointOne[0] + pointOne[1]*pointOne[1]) - (pointTwo[0]*pointTwo[0] + pointTwo[1]*pointTwo[1]);
        }
        );

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
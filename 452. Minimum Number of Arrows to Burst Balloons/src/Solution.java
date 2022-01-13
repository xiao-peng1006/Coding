class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[0] == o2[0]) return 0;
            if (o1[0] < o2[0]) return -1;
            return 1;
        });


        List<List<Integer>> list = new ArrayList<>();
        int[] pre = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] cur = points[i];
            if (pre[1] >= cur[0]) {
                pre[0] = cur[0];
                pre[1] = Math.min(pre[1], cur[1]);
            } else {
                list.add(new ArrayList(Arrays.asList(pre)));
                pre = cur;
            }

            if (i == points.length - 1) {
                list.add(new ArrayList(Arrays.asList(pre)));
            }
        }

        return list.size();
    }
}
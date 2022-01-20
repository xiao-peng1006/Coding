class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            int curR = cur.getKey(), curC = cur.getValue();
            for (int i = 0; i < 4; i++) {
                int newR = curR + dir[i][0];
                int newC = curC + dir[i][1];
                if (newR >= 0 && newC >= 0 && newR < m && newC < n) {
                    if (dist[newR][newC] > dist[curR][curC] + 1) {
                        dist[newR][newC] = dist[curR][curC] + 1;
                        q.add(new Pair(newR, newC));
                    }
                }
            }
        }

        return dist;
    }


}
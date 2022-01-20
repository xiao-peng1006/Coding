class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = q.size();
        while (!q.isEmpty()) {
            for (int i = 0; i < n; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int j = 0; j < 4; j++) {
                    int newR = r + dir[j][0];
                    int newC = c + dir[j][1];
                    if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        q.add(new int[]{newR, newC});
                    }
                }
            }

            n = q.size();
            if (n != 0) minutes++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int maxArea = 0;

        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int count = q.size();
                        for (int k = 0; k < count; k++) {
                            Pair<Integer, Integer> idx = q.poll();
                            int r = idx.getKey();
                            int c = idx.getValue();

                            if (grid[r][c] == 1) {
                                area++;
                            } else {
                                continue;
                            }

                            if (r - 1 >= 0 && !visited[r-1][c]) {
                                q.add(new Pair(r - 1, c));
                                visited[r - 1][c] = true;
                            }

                            if ((r + 1 < grid.length && !visited[r+1][c])) {
                                q.add(new Pair(r + 1, c));
                                visited[r + 1][c] = true;
                            }

                            if (c - 1 >= 0 && !visited[r][c-1]) {
                                q.add(new Pair(r, c - 1));
                                visited[r][c - 1] = true;
                            }

                            if ((c + 1 < grid[0].length && !visited[r][c+1])) {
                                q.add(new Pair(r, c + 1));
                                visited[r][c + 1] = true;
                            }
                        }
                    }
                }


                maxArea = Math.max(maxArea, area);
                area = 0;
            }
        }
        return maxArea;
    }
}
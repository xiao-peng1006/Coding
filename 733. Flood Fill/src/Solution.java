class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        visited[sr][sc] = true;
        int target = image[sr][sc];

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Pair<Integer, Integer> idx = q.poll();
                int r = idx.getKey();
                int c = idx.getValue();

                if (image[r][c] == target) {
                    image[r][c] = newColor;
                } else {
                    continue;
                }

                if (r - 1 >= 0 && !visited[r-1][c]) {
                    q.add(new Pair(r - 1, c));
                    visited[r - 1][c] = true;
                }

                if ((r + 1 < image.length && !visited[r+1][c])) {
                    q.add(new Pair(r + 1, c));
                    visited[r + 1][c] = true;
                }

                if (c - 1 >= 0 && !visited[r][c-1]) {
                    q.add(new Pair(r, c - 1));
                    visited[r][c - 1] = true;
                }

                if ((c + 1 < image[0].length && !visited[r][c+1])) {
                    q.add(new Pair(r, c + 1));
                    visited[r][c + 1] = true;
                }
            }
        }
        return image;
    }
}
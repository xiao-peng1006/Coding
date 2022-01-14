class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                q.add(mat[i][j]);
            }
        }

        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (q.isEmpty()) {
                    return mat;
                }
                ans[i][j] = q.poll();
            }
        }
        return q.isEmpty() ? ans : mat;
    }
}
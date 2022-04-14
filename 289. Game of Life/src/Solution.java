class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        this.m = board.length;
        this.n = board[0].length;

        int[][] copyOfBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyOfBoard[i][j] = board[i][j];
            }
        }

        int lives = 0;
        for (int i = 0; i < m; i++) {
            lives = 0;
            for (int j = 0; j < n; j++) {
                lives = nearByLives(copyOfBoard, i, j, dirs);
                if (copyOfBoard[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if (lives == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }

    }

    public int nearByLives(int[][] board, int row, int col, int[][] dirs) {
        int lives = 0;
        for (int[] dir :  dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < this.m && c >= 0 && c < this.n) {
                if (board[r][c] == 1) {
                    lives++;
                }
            }
        }

        return lives;
    }
}
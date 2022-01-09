class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0,1}, {1,0},{0,-1}, {-1,0}};
        int x = 0, y = 0, facing = 0;

        for (int i : instructions.toCharArray()) {
            if (i == 'L') {
                facing = (facing + 3)%4;
            } else if (i == 'R') {
                facing = (facing + 1)%4;
            } else {
                x += directions[facing][0];
                y += directions[facing][1];
            }
        }

        return (x == 0 & y == 0) || (facing != 0);
    }
}
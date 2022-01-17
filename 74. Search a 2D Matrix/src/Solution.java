class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0) return false;

        int start = 0, end =  m * n - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            int midVal = matrix[mid/n][mid%n];
            if (target > midVal) {
                start = mid + 1;
            } else if (target < midVal) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
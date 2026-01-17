package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrixII {


    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        /**
         * Why start at top‑right?
         *
         * Everything to the left in the same row ≤ the current value because the row is sorted.
         * Everything below in the same column ≥ the current value because the column is sorted.
         *
         * So from this corner each comparison tells you whether to move left or down while safely discarding
         * a whole strip of cells.
         */
        int r = 0, c = cols - 1;
        while(r < rows && c >= 0) {
            if(matrix[r][c] == target) return true;

            if(matrix[r][c] < target) r++;
            else c--;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {

        int M = matrix.length;
        for(int i = 0;  i < M; i++) {
            if(binarySearch(matrix[i], target)) return true;
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target) {

        int lo = 0, hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}

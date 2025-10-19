package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

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

package proj.hobby.dsa.binarySearch;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        //int loM = 0, loN = 0, hiM = M-1, hiN = N-1;
        int lo = 0, hi = M*N-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midM = mid / N;
            int midN = mid % N;
            int curr = matrix[midM][midN];
            if( curr > target) {
                hi = mid - 1;
            } else if(curr < target) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }
}

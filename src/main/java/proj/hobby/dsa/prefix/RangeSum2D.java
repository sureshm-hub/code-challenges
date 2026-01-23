package proj.hobby.dsa.prefix;

/**
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
public class RangeSum2D {

    private int[][] pre;

    public RangeSum2D(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        pre = new int[rows + 1][cols + 1];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                // pre[r+1][c] - region from prefix[0,0] to col before current cell
                // pre[r][c+1] - region from prefix[0,0] to row before current cell
                // pre[r][c]  - "remove" region from prefix[0,0] to row, col before current cell
                // matrix[r][c] - "current cell"
                pre[r+1][c+1] = pre[r+1][c] + pre[r][c+1] - pre[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pre[row2 + 1][col2 + 1] - pre[row2 + 1][col1] - pre[row1][col2 + 1] + pre[row1][col1];
    }
}

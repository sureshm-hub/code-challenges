package proj.hobby.dsa.prefix;

/**
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
public class RangeSum2D {

    private int[][] pre;

    public RangeSum2D(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        pre = new int[M + 1][N + 1];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                pre[i+1][j+1] = pre[i+1][j] + pre[i][j+1] - pre[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pre[row2 + 1][col2 + 1] - pre[row2 + 1][col1] - pre[row1][col2 + 1] + pre[row1][col1];
    }
}

package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    int cur = findMaxSquare(matrix, i, j);
                    max = Math.max(cur, max);
                }
            }
        }

        return max * max;
    }

    private int findMaxSquare(char[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = Math.min(m-i, n-j);

        int cur = 1;

        while(cur < max) {
            int r = i + cur;
            int c = j + cur;

            for(int y = j; y <= c; y++) {
                if(matrix[r][y] == '0') return cur;
            }

            for(int x = i; x <= r; x++) {
                if(matrix[x][c] == '0') return cur;
            }

            cur++;
        }
        return cur;
    }
}

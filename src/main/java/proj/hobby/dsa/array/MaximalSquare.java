package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {

    // dynamic programming based solution
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for(int y = 0; y < rows; y++) {
            if(matrix[y][0] == '1') {
                dp[y][0] = 1;
                maxSide = 1;
            }
        }

        for(int x = 0; x < cols; x++) {
            if(matrix[0][x] == '1') {
                dp[0][x] = 1;
                maxSide = 1;
            }
        }

        for(int y = 1; y < rows; y++) {
            for(int x = 1; x< cols; x++) {
                if(matrix[y][x] == '0') {
                    dp[y][x] = 0;
                    continue;
                }

                dp[y][x] = 1 + Math.min( dp[y - 1][x - 1],
                        Math.min( dp[y][x - 1], dp[y - 1][x]));

                maxSide = Math.max(maxSide, dp[y][x]);
            }
        }

        return maxSide * maxSide;
    }


    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxSide = 0;

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    int cur = findMaxSquare(matrix, i, j);
                    maxSide = Math.max(cur, maxSide);
                }
            }
        }

        return maxSide * maxSide;
    }

    private int findMaxSquare(char[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxSideAllowed = Math.min(m-i, n-j);

        int cur = 1;

        while(cur < maxSideAllowed) {
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

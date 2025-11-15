package proj.hobby.dsa.dp.multiDimensional;

/**
 *
 * https://leetcode.com/contest/weekly-contest-475/problems/maximum-path-score-in-a-grid/description/
 */
public class MaxPathScore {

    public int maxPathScore(int[][] grid, int k) {
        int M = grid.length;
        int N = grid[0].length;

        int[][][] dp = new int[M][N][k + 1];

        for(int i = 0; i < M; i ++)
            for(int j = 0; j < N; j++)
                for(int c = 0; c < k+1; c++)
                    dp[i][j][c] = Integer.MIN_VALUE;

        int v0 = grid[0][0];
        int sc = v0 == 0 ? 0 : 1;
        int ss = v0;

        if(sc <= k) {
            dp[0][0][sc] = ss;
        }

        for(int i = 0; i < M; i ++) {
            for(int j = 0; j < N; j++) {
                if(i == 0 && j == 0) continue;

                int v = grid[i][j];
                int ac = v == 0 ? 0 : 1;
                int as = v;

                for(int c = 0; c < k+1; c++) {
                    int prevC = c - ac;
                    if(prevC < 0) continue;

                    int bestPrev = Integer.MIN_VALUE;

                    if(i > 0) bestPrev = Math.max(bestPrev, dp[i - 1][j][prevC]);

                    if(j > 0) bestPrev = Math.max(bestPrev, dp[i][j - 1][prevC]);

                    if(bestPrev != Integer.MIN_VALUE)
                        dp[i][j][c] = Math.max(dp[i][j][c], bestPrev + as);
                }
            }
        }

        int ans = -1;
        for(int c = 0; c <= k; c++) ans = Math.max(ans, dp[M-1][N-1][c]);

        return ans;
    }
}

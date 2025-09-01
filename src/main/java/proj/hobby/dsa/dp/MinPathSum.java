package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] min = new int[M][N];

        min[0][0] = grid[0][0];
        for(int j = 1; j < N; j++) {
            min[0][j] = min[0][j-1]+grid[0][j];
        }

        for(int i =1; i < M; i++) {
            min[i][0] = min[i-1][0]+grid[i][0];
        }

        for(int i =1; i <M; i++) {
            for(int j =1; j < N; j++) {
                min[i][j] = grid[i][j]+Math.min(min[i-1][j], min[i][j-1]);
            }
        }

        return min[M-1][N-1];
    }

}

package proj.hobby.dsa.dp;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        int[][] paths = new int[M][N];
        paths[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int top = 0, left =0;
                if(i-1 >= 0) {top = paths[i-1][j]; }
                if(j-1 >= 0) {left = paths[i][j-1];}
                if( !(i == 0 && j == 0) && obstacleGrid[i][j] != 1)  {
                    paths[i][j] = top+left;
                }
            }
        }
        return paths[M-1][N-1];
    }

}

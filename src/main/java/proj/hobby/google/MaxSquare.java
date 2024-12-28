package proj.hobby.google;

public class MaxSquare {

    public int findMaxSquare(int[][] matrix) {

        int M = matrix.length;
        int N = matrix[0].length;
        int[][] dp = new int[M][N];
        int maxSize = 0;
        for(int i =0; i < M; i++) {
            for(int j=0; j < N; j ++) {
                if(matrix[i][j] == 1) {
                    if(i ==0 || j ==0) {
                        dp[i][j] = 1; // edges can only have a  1X1 square
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp [i-1][j-1])+1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }
}

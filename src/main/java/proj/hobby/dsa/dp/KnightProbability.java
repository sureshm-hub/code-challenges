package proj.hobby.dsa.dp;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/knight-probability-in-chessboard/description
 *
 */
public class KnightProbability {

    public double knightProbability(int n, int k, int row, int column) {

        int[][] moves = new int[][]{{-2, 1}, {-2, -1}, {-1,-2}, {-1, 2}, {2,-1}, {2, 1}, {1,-2}, {1, 2}};

        final double PROB = 0.125;// 1/8th of move

        double[][] state = new double[n][n];// probability state
        state[row][column] = 1.0;// starting cell

        for(int i = 0; i < k; i++) {
            double[][] newState = new double[n][n];

            for(int r = 0; r < n; r++)
                for(int c = 0; c < n; c++)
                    if(state[r][c] > 0.0) {
                        for(int[] mv : moves) {
                            int nr = r + mv[0];
                            int nc = c + mv[1];

                            if(nr <  0 || nc < 0 || nr >= n || nc >= n) continue;

                            newState[nr][nc] += state[r][c] * PROB;
                        }
                    }

            state = newState; // now we are in new state start counting from here
        }

        return Arrays.stream(state).flatMapToDouble(Arrays::stream).sum();
    }
}

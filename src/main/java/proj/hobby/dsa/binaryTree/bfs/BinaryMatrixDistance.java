package proj.hobby.dsa.binaryTree.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * multi source BFS
 *
 * https://leetcode.com/problems/01-matrix/
 */
public class BinaryMatrixDistance {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] out = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();

        // Initialize distances and queue
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    out[i][j] = 0;
                    q.offer(new int[]{i, j});  // start BFS from all zeros
                } else {
                    out[i][j] = Integer.MAX_VALUE; // infinity
                }
            }
        }

        int[][] neighbs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        // Multi-source BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] d : neighbs) {
                int nx = x + d[0];
                int ny = y + d[1];

                // in bounds and can improve distance
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (out[nx][ny] > out[x][y] + 1) {
                        out[nx][ny] = out[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return out;
    }
}

package proj.hobby.dsa.binaryTree.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * https://leetcode.com/problems/max-area-of-island
 *
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int r = 0; r < m; r++)
            for(int c = 0; c < n; c++) {
                int a = areaDfs(grid, r, c);
                max = Math.max(max, a);
            }

        return max;
    }

    private int areaDfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || c < 0 || r >= m || c >= n) return 0;

        if(grid[r][c] == 1) {
            grid[r][c] = 2;// mark as visited
            return 1 + areaDfs(grid, r + 1, c)  + areaDfs(grid, r - 1 , c) + areaDfs(grid, r, c + 1) + areaDfs(grid, r, c -1);
        }
        return 0;
    }

    private int area(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int a = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];
            if(grid[cr][cc] == 1) { // check if another path has visited this already
                grid[cr][cc] = 0; //mark visited
                a++;// incr area
                for(int[] dir : dirs) {
                    int nr = dir[0] + cr;
                    int nc = dir[1] + cc;
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;// out of grid
                    if(grid[nr][nc] != 0) {
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return a;
    }
}

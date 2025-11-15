package proj.hobby.dsa.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 */
public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int M = heights.length;
        int N = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < M; i ++) {
            for(int j = 0; j < N; j++) {
                boolean[][] po = new boolean[M][N]; // visited po
                boolean[][] ao = new boolean[M][N]; // visited ao
                if(dfs(heights, i, j, po, "P") && dfs(heights, i, j, ao, "O")) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private boolean dfs(int[][] h, int i, int j, boolean[][] visited, String ocean) {
        int M = h.length;
        int N = h[0].length;

        if((i == 0 || j == 0) && "P".equals(ocean)) return true;
        if((i == M - 1 || j == N - 1) && "O".equals(ocean)) return true;

        visited[i][j] = true;

        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[] dir : DIRS) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if(newX >= 0 && newX < M && newY >= 0 && newY < N &&
                    !visited[newX][newY] && h[newX][newY] <= h[i][j]) {
                boolean flow = dfs(h, newX, newY, visited, ocean);
                if(flow) return flow;
            }
        }
        return false;
    }
}

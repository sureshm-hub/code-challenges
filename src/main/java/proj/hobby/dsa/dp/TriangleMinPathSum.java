package proj.hobby.dsa.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/triangle/
 */
public class TriangleMinPathSum {

    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(triangle, 0, 0, memo);
    }

    private int dfs(List<List<Integer>> tri, int r, int c, Map<String, Integer> memo) {
        if (r == tri.size() - 1) {
            return tri.get(r).get(c);
        }

        String key = r + "," + c;
        if(memo.get(key) != null) {
            return memo.get(key);
        }

        int down = dfs(tri, r + 1, c, memo);

        int downRight = dfs(tri, r + 1, c + 1, memo);
        memo.put(key, tri.get(r).get(c) + Math.min(down, downRight));
        return memo.get(key);
    }
}

package proj.hobby.dsa.graph.dfs;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/matchsticks-to-square
 */
public class MatchSticksToSquare {

    public boolean makesquare(int[] matchsticks) {
        int perim = Arrays.stream(matchsticks).sum();
        if( perim % 4 != 0) return false;

        int side = perim / 4;

        Arrays.sort(matchsticks);
        int[] edges = new int[]{side, side, side, side};

        return dfs(matchsticks, matchsticks.length - 1, edges);
    }

    private boolean dfs(int[] matches, int selected, int[] edges) {
        if(selected < 0) return Arrays.stream(edges).sum() == 0; // all edges filled up

        for(int i  = 0; i < edges.length; i ++) {
            if(matches[selected] > edges[i]) continue;

            edges[i] -= matches[selected];

            if(dfs(matches, selected - 1, edges)) return true;
            edges[i] += matches[selected];
        }
        return false;
    }

}

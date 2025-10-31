package proj.hobby.dsa.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 */
public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {

        List<Integer> rslt = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            dfs(n, i, rslt);
        }
        return rslt;
    }

    private void dfs(int n, int c, List<Integer> rslt) {
        if(c > n) return;

        rslt.add(c);

        for(int i = 0; i <= 9; i++) {
            dfs(n, c * 10 + i, rslt);
        }
    }
}

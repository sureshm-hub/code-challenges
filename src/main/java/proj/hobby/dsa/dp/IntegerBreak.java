package proj.hobby.dsa.dp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        int max = dfs(n, memo);
        return max;
    }

    private int dfs(int n, Map<Integer, Integer> memo) {
        if(n == 1) return 0;

        if(memo.containsKey(n)) return memo.get(n);

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n - 1; i++) {
            int iComp = n - i;
            int maxIComp = dfs(iComp, memo);
            max = Math.max(max, Math.max(i * iComp, i * maxIComp));
        }
        memo.put(n, max);
        return max;
    }
}

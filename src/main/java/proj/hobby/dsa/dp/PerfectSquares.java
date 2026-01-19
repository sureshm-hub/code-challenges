package proj.hobby.dsa.dp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class PerfectSquares {

    // Using DP here
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = i; // n 1's
            for(int j = 1; j * j  <= i ; j++) {
                dp[i] = Math.min( dp[i],  dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquaresMemo(int n) {

        Map<Integer, Integer> cache = new HashMap<>();
        minSquares(n, cache);
        return cache.get(n);
    }

    private int minSquares(int n, Map<Integer, Integer> cache) {
        if( n == 0) return 0;
        if(cache.containsKey(n))  return cache.get(n);

        int min = n; // n 1's
        for(int i = 1; i * i <= n; i++) {
            int num = n - i * i;
            int cur = 1 + minSquares(num, cache);
            min  = Math.min(min, cur);
        }
        cache.put(n, min);
        return min;
    }
}

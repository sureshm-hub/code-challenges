package proj.hobby.dsa.dp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class PerfectSquares {

    public int numSquares(int n) {

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

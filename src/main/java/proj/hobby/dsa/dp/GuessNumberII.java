package proj.hobby.dsa.dp;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 *
 */
public class GuessNumberII {

    public int getMoneyAmount(int n) {

        int[][] mem = new int[n + 1][n + 1];

        Arrays.stream(mem).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE));

        return getMoneyAmount(1, n, mem);
    }

    private int getMoneyAmount(int lo, int hi, int[][] mem) {

        if(lo >= hi) return 0;

        if(mem[lo][hi] != Integer.MAX_VALUE) return mem[lo][hi];

        for(int k = lo; k <= hi; k++) {
            mem[lo][hi] = Math.min(mem[lo][hi],
                    Math.max(getMoneyAmount(lo, k - 1, mem),
                            getMoneyAmount(k+1, hi, mem) ) + k);
        }
        return mem[lo][hi];
    }
}

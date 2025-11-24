package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/ones-and-zeroes/description
 */
public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for(String s : strs) {
            int zeros = (int) s.chars().filter(c -> c == '0').count();
            int ones = s.length() - zeros;
            for(int i = m; i >= zeros; i--)
                for(int j = n; j >= ones; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);

        }

        return dp[m][n];
        //return findMax(strs, m, n, 0);
    }

    private int findMax(String[] strs, int m, int n, int idx) {
        if(idx >= strs.length) return 0;

        int max = findMax(strs, m, n, idx + 1); // excl current idx;

        // for(String s : strs) {
        String s = strs[idx];
        int tot = s.length();
        int bits1 = (int) s.chars().filter(c -> c == '1').count();//Integer.bitCount(Integer.parseInt(s, 2)); -- causes overflow for long lengthed strings Or throw NumberFormatException
        int bits0 = tot - bits1;

        if (bits0 <= m || bits1 <= n) {
            int inc = 1 + findMax(strs, m - bits0, n - bits1, idx + 1);
            max = Math.max(inc, max);
        }

        // }

        return max;
    }
}

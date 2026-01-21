package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/nim-game/description/
 */
public class NimGame {

    public boolean canWinNim(int n) {
        // Boolean[] memo = new Boolean[n + 1];
        // return canWin(n,memo);
        return n % 4 != 0;
    }

    private boolean canWin(int n, Boolean[] memo) {
        if(n <= 0) return false;
        if(n <= 3) return true; //base

        if(memo[n] != null) return memo[n];

        boolean result = !canWin(n - 1, memo) ||
                !canWin(n - 2, memo) ||
                !canWin(n - 3, memo);

        return memo[n] = result;
    }

    private boolean canWinDp(int n) {
         //base case
         if(n <= 3) return true;

         boolean[] dp = new boolean[n+1];
         dp[1] = true;
         dp[2] = true;
         dp[3] = true;
         for(int i = 4; i <= n; i++) {
             dp[i] = !dp[i - 1] || !dp[i - 2] || !dp[i -3];
         }
         return dp[n];
    }
}

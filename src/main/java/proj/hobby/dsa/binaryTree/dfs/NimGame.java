package proj.hobby.dsa.binaryTree.dfs;

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
}

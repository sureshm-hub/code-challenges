package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/can-i-win
 */
public class CanIWin {
    // TLE
    // public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

    //     if(desiredTotal <= maxChoosableInteger) return true;

    //     int max = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
    //     if(desiredTotal > max) return false;

    //     Map<Integer, Boolean> mem  = new HashMap<>();
    //     return canIWin(desiredTotal, 0, maxChoosableInteger, mem);
    // }

    // private boolean canIWin(int desired, int used, int max, Map<Integer, Boolean> mem) {
    //     if(desired <= 0) return false;

    //     if(mem.containsKey(used)) return mem.get(used);

    //     for(int i = 1; i <= max; i++) {
    //         if((used >> i & 1) == 1 ) // i is used already
    //             continue;
    //         if(!canIWin(desired - i, used | 1 << i, max, mem)) return true;
    //     }
    //     mem.put(used, false);
    //     return false;
    // }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // Sum of 1..maxChoosableInteger
        int sumAll = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        // If even the total sum cannot reach desiredTotal, first player can never win
        if (sumAll < desiredTotal) {
            return false;
        }

        // If desiredTotal is 0 or less, or first player can win in one move
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }

        // Memo for states: -1 = unknown, 0 = lose, 1 = win
        int[] memo = new int[1 << maxChoosableInteger];
        java.util.Arrays.fill(memo, -1);

        return canWin(desiredTotal, 0, maxChoosableInteger, memo);
    }

    private boolean canWin(int remaining, int usedMask, int max, int[] memo) {
        // If remaining <= 0, the previous player already reached the total and won.
        // So the current player is in a losing state.
        if (remaining <= 0) {
            return false;
        }

        if (memo[usedMask] != -1) {
            return memo[usedMask] == 1;
        }

        // Try all numbers from 1 to max
        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);

            // If this number is already used, skip
            if ((usedMask & bit) != 0) {
                continue;
            }

            // If picking i reaches or exceeds the remaining total, we win immediately
            if (i >= remaining) {
                memo[usedMask] = 1;
                return true;
            }

            // Otherwise, simulate picking i and see if opponent loses
            int newMask = usedMask | bit;
            boolean opponentCanWin = canWin(remaining - i, newMask, max, memo);

            if (!opponentCanWin) {
                // We found a move that forces the opponent into a losing state
                memo[usedMask] = 1;
                return true;
            }
        }

        // No winning move found; current state is losing
        memo[usedMask] = 0;
        return false;
    }

}

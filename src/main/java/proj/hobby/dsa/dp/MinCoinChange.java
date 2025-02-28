package proj.hobby.dsa.dp;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * Approach: DP
 * Complexity:
 *  Time: O(N*M) - N is amount and M is coins
 *  Space: O(N)
 *
 *
 */
public class MinCoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];// amounts to store the min coins needed for each amount
        dp[0] = 0;//to make a zero amount we don't need a zero coin
        for(int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE; // initialize to max value so we pick the first available coin count
        }

        for(int i = 1 ; i <= amount; i++) {
            for(int coin: coins) {
                if(coin <= i && dp[i-coin]!= Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        MinCoinChange minCoinChange = new MinCoinChange();
        System.out.println("min Coin Change: "+minCoinChange.coinChange(new int[]{1,2,5}, 11));
        System.out.println("min Coin Change: "+minCoinChange.coinChange(new int[]{2}, 3));
        System.out.println("min Coin Change: "+minCoinChange.coinChange(new int[]{1}, 0));
    }
}

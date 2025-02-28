package proj.hobby.dsa.dp;

/**
 * https://leetcode.com/problems/coin-change-ii/
 *
 * Approach:
 *  Dynamic Programming
 *
 * Complexity:
 *  Time: O(N*M) - N is amount and M is coins
 *  Space: O(N) - N is amount
 *
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1]; // track amounts from 0 to amount
        dp[0] = 1; // only 1 way to make 0 amount is by using no coin

        for(int coin : coins) { // avoid duplicate paths while counting
            for(int i = coin; i < dp.length; i++) {
                dp[i] += dp[i-coin]; // for each coin we have an edge connecting i-coin to i
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 counter = new CoinChange2();
        System.out.println("Coin Change2: "+ counter.change(5, new int[]{1,2,5}));
        System.out.println("Coin Change2: "+ counter.change(3, new int[]{5}));
        System.out.println("Coin Change2: "+ counter.change(10, new int[]{10}));
    }
}

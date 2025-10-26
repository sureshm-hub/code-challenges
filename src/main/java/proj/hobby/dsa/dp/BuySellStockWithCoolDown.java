package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class BuySellStockWithCoolDown {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;

        int[] dp = new int[n]; // dp

        for(int i = 1; i < prices.length; i++) {
            int maxProfitI = 0; // max profit selling on i
            for(int j = 0; j < i; j++) {
                int prev = (j >= 2) ? dp[j-2] : 0;
                maxProfitI = Math.max(maxProfitI, prices[i] - prices[j] + prev);
            }
            dp[i] = Math.max(dp[i - 1], maxProfitI);
        }

        return dp[n - 1];
    }
}

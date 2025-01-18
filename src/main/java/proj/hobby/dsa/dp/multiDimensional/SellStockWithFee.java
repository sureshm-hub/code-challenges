package proj.hobby.dsa.dp.multiDimensional;

/**
 *
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=study-plan-v2&envId=leetcode-75
 *
 *  Approach: Dynamic Programming
 *
 *  Complexity:
 *      Time: (O(N)
 *      Space: O(N)
 *
 */
public class SellStockWithFee {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0; // Initial state: no cash no profit
        int hold = -prices[0]; // Initial state: holding the stock after buying  on day 0

        for(int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, prices[i]+hold-fee); // case: sell stock
            hold = Math.max(hold, cash-prices[i]); // case: buy stock
        }
        return cash;
    }

    /**
     * Approach: Recursion
     *
     * Complexity:
     *  Time: O(2^N)
     *  Space: O(1)
     */
    public int maxProfitRecursion(int[] prices, int fee) {
        return maxProfitHelper(prices, 0, 0, fee);
    }

    private int maxProfitHelper(int[] prices, int i, int hold, int fee) {
        //Base Case: if  we reached the end no more profit can be made
        if(i == prices.length) {
            return 0;
        }

        if(hold == 0) { // we don't hold stock so we can buy or skip
            return Math.max( maxProfitHelper(prices, i+1, 0, fee), // skip  buying
                    -prices[i]+maxProfitHelper(prices, i+1, 1, fee)); // buy i

        } else { // we hold stock so we can sell or skip
            return  Math.max(maxProfitHelper(prices, i+1, 1, fee), // skip selling
                    prices[i]-fee+maxProfitHelper(prices, i+1, 0, fee)); // sell
        }
    }

    public static void main(String[] args) {
        SellStockWithFee ssf = new SellStockWithFee();
        System.out.println("Max Profit: "+ssf.maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println("Max Profit: "+ssf.maxProfit(new int[]{1,3,7,5,10,3}, 3));

        // recursion
        System.out.println("Max Profit: "+ssf.maxProfitRecursion(new int[]{1,3,2,8,4,9}, 2));
        System.out.println("Max Profit: "+ssf.maxProfitRecursion(new int[]{1,3,7,5,10,3}, 3));
    }
}

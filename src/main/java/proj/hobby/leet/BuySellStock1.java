package proj.hobby.leet;

/**

 Problem:
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150

 Clarifying Q's:
    Can you sell then buy?

 Pseudocode:

    int maxProfit = 0
    int start = 0;
    int min = prices[0]
    for i:0 -> prices.length
        if prices[i] < prices[0]
            min = price [i]
        else
            maxProfit = Math.max(maxProfit, price[i] - min)

    return maxProfit

 Complexity: O(N) time & O(1) space

 */
public class BuySellStock1 {

    public int maxProfit(int[] prices) {
        if(prices.length ==0){
            return 0;
        }

        int maxProfit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i]-min);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuySellStock1 stockProfit = new BuySellStock1();
        System.out.println(" max profit: "+ stockProfit.maxProfit(new int[]{}));
        System.out.println(" ==== ");

        System.out.println(" max profit: "+ stockProfit.maxProfit(new int[]{10}));
        System.out.println(" ==== ");

        System.out.println(" max profit: "+ stockProfit.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(" ==== ");

        System.out.println(" max profit: "+ stockProfit.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(" ==== ");

    }
}

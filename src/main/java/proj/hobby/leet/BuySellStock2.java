package proj.hobby.leet;

/**

 Problem:
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150

 Clarifying Q's:

 Pseudo Code:
    Greedy Algo

Complexity:
    O(N)

 */

public class BuySellStock2 {

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return  0;
        }
        int max =0;
        for(int i=1;i<prices.length;i++) {
            max += Math.max(0, prices[i]-prices[i-1]);
        }
        return max;
    }

    public static void main(String[] args) {
        BuySellStock2 stockProfit = new BuySellStock2();

        System.out.println("max: "+stockProfit.maxProfit( new int[]{7,1,5,3,6,4}));
        System.out.println("=====");

        System.out.println("max: "+stockProfit.maxProfit( new int[]{1,2,3,4,5}));
        System.out.println("=====");

        System.out.println("max: "+stockProfit.maxProfit( new int[]{5,4,3,2,1}));
        System.out.println("=====");
    }


}

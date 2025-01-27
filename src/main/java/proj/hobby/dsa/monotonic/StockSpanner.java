package proj.hobby.dsa.monotonic;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/online-stock-span/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Use ArrayList to keep track of prices
 *
 *
 */
public class StockSpanner {

    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    /**
     * Complexity:
     *
     *  Time: O(1) for each price
     *  Space: O(N) for storing N prices and spans of the stock
     *
     * @param price
     * @return
     */
    public int next(int price) {
        int span = 1;

        // pop elements from stack while the current price is greater than or equal to price at top of the stack
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // add the span of the popped price
        }

        // push the current price onto stack
        stack.push(new int[]{price, span});
        return span;
    }


    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();

        System.out.println("Span: "+spanner.next(100)); // return 1
        System.out.println("Span: "+spanner.next(80));  // return 1
        System.out.println("Span: "+spanner.next(60));  // return 1
        System.out.println("Span: "+spanner.next(70));  // return 2
        System.out.println("Span: "+spanner.next(60));  // return 1
        System.out.println("Span: "+spanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println("Span: "+spanner.next(85));  // return 6
    }
}

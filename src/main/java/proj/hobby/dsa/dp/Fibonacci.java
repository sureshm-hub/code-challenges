package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/fibonacci-number/description
 *
 */
public class Fibonacci {

    public int fib(int n) {

        if(n <= 1) return n;

        int prev = 0;
        int cur = 1;
        for(int i = 2; i <= n; i++) {
            int next = cur + prev;
            prev = cur;
            cur = next;
        }
        return cur;

    }
}

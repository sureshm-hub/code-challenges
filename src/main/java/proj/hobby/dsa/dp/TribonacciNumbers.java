package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75
 *
 */
public class TribonacciNumbers {

    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        if( n == 0) {
            return t0;
        }
        if (n == 1) {
            return t1;
        }
        if (n == 2 ) {
            return t2;
        }
        int tn =0;
        for(int i = 3; i <= n; i++) {
            tn = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return tn;
    }
}

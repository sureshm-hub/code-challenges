package proj.hobby.dsa.math;

/**
 * https://leetcode.com/problems/powx-n/description/
 */
public class Power {

    public double myPow(double x, int n) {
        long nl = n;
        if( n < 0) {
            x = 1/x;
            nl = -nl;
        }
        if(x == -1.0){
            return n%2 == 0 ? 1.0 : -1.0;
        }
        double result = 1;
        for(int i = 1; i <= nl; i++) {
            result *= x;
            if(result == 0.0  || result == 1.0) break;
        }
        return result;
    }
}

package proj.hobby.dsa.binarySearch;

/**
 * https://leetcode.com/problems/sqrtx/description/
 */
public class Sqrt {

    public int mySqrt(int x) {
        if(x <= 1) return x;
        int lo = 1, hi = x / 2;
        int ans =0;
        while (lo <= hi) {
            int sqrt = lo + ( hi - lo ) / 2;
            if((long) sqrt*sqrt <= x) {
                ans = sqrt;
                lo = sqrt + 1;
            } else {
                hi = sqrt - 1;
            }
        }
        return ans;
    }

}

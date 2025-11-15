package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/arranging-coins/description/
 *
 */
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        long nl = (long) n;
        long lo = 1, hi = n;

        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long used = mid * (mid + 1) / 2;

            if(used == nl) return (int) mid ;
            else if( used < nl) lo = mid + 1;
            else hi = mid - 1;
        }

        return (int) hi;

        // int rows = 1;
        // while ((n - rows) >= 0 ) {
        //     n -= rows;
        //     rows++;
        // }
        // return --rows;
    }
}

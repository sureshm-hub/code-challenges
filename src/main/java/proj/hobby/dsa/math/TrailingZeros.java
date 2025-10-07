package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes
 *
 */
public class TrailingZeros {

    public int trailingZeroes(int n) {
        int tz = 0;
        int div = 5;

        while(n > 0) {
            tz += n/div;
            n /= 5;
        }

        return tz;
    }

}

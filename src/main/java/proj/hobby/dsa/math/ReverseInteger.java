package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/reverse-integer/
 *
 */
public class ReverseInteger {

    public int reverse(int x) {

        if(x == Integer.MIN_VALUE) return 0;
        int sign = 1;
        if(x < 0) {
            sign = -1;
            x *= sign;
        }

        int d = 1;
        while(x/d >= 10) {
            d = d*10;
        }

        int rev = 0;
        while(d >= 1) {
            if(d == 1000000000 && x%10 > 2) {
                return 0;
            }
            int trail = x%10;
            rev += (trail) * d;
            if(rev < 0) return 0;

            x -= trail;
            x /= 10;
            d /= 10;
        }
        rev += x;
        return sign * rev;

    }
}

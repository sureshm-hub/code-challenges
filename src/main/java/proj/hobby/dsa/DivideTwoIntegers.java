package proj.hobby.dsa;

/**
 *
 * https://leetcode.com/problems/divide-two-integers/
 *
 */

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if(divisor ==0) {
            throw new IllegalArgumentException("divisor cannot be zero");
        }

        if( dividend ==0) {
            return 0;
        }

        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        int quotient = 0;

        while(dividendL >= divisorL) {
            long tempDivisor = divisorL;
            int multiplier = 1;

            while( dividendL >= (tempDivisor << 1)) {
                tempDivisor <<=  1;
                multiplier <<= 1;
            }

            quotient += multiplier;
            dividendL -= tempDivisor;
        }
        return isNegative ? -quotient : quotient;
    }
}

package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/power-of-four/description/
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        long power = 1;
        long nl = (long) n;
        while(power <= nl) {
            if(power == nl) return true;
            power *= 4;
        }
        return false;
    }

    public boolean isPowerOfFour2(int n) {
        long power = 1;
        long nl = (long) n;
        while(power <= nl) {
            if(power == nl) return true;
            power = power << 2;
        }
        return false;
    }

}

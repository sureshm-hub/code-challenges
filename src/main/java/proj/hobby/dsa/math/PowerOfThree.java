package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {

        if(n <= 0) return false;

        while(n > 1) {
            if(n % 3 != 0) return false;
            n /= 3;
        }

        return true;
    }
}

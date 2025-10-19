package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

    public boolean isUgly(int n) {

        if(n == 0) return false;

        while(n != 1 && n % 2 == 0) n /= 2;

        while(n != 1 && n % 3 == 0) n /= 3;

        while(n != 1 && n % 5 == 0) n /= 5;

        return n == 1;
    }
}

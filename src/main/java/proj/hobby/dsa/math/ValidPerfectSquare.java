package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/valid-perfect-square/description/
 *
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

}

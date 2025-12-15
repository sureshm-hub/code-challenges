package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/sum-of-square-numbers/description
 *
 */
public class JudgeSquares {

    public boolean judgeSquareSum(int c) {

        long l = 0;
        long r = (long) Math.sqrt(c);

        while(l <= r) {
            long sum = l * l + r * r;
            if(sum == (long) c) return true;

            if(sum < (long)c) l++;
            else r--;
        }
        return false;
    }
}

package proj.hobby.dsa.bitwise;

/**
 *
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 *
 */
public class BitwiseNumbersRangeAnd {

    public int rangeBitwiseAnd(int left, int right) {
        int result = right;
        for(int i = left; i < right; i++) {
            result &= i;
            if(result == 0) return 0;
        }

        return result;
    }
}

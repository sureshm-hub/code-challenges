package proj.hobby.dsa.array;

/**
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description
 */
public class ConverInt {

    public int[] getNoZeroIntegers(int n) {
        if ( n == 0) return new int[] {1, -1};

        int a = 1, b = n-a;
        while(Integer.toString(a).indexOf("0") != -1 || Integer.toString(b).indexOf("0") != -1) {
            a++;
            b--;
        }
        return new int[] {a , b};
    }
}

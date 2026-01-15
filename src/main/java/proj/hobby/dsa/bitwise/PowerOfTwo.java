package proj.hobby.dsa.bitwise;

/**
 *
 * https://leetcode.com/problems/power-of-two/
 *
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        String s = Integer.toString(n, 2); // msb to lsb ex:16 -> 1000
        int N = s.length();
        for(int i = 1; i < N; i++) {
            if(s.charAt(i) != '0') return false;
        }
        return true;
    }

    public boolean isPowerOfTwoBitwise(int n) {
        return n > 0 && ((n & n - 1) == 0);
    }
}

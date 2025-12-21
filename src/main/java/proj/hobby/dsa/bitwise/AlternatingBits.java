package proj.hobby.dsa.bitwise;

/**
 *
 * https://leetcode.com/problems/binary-number-with-alternating-bits/description
 *
 */
public class AlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int prev = n & 1; // place holder for last lsb
        n = n >> 1;
        while(n != 0) {
            int cur = n & 1;// current lsb
            if((prev ^ cur) != 1) return false;
            n = n >> 1;
            prev = cur;
        }
        return true;
    }
}

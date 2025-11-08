package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/integer-replacement/
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        int ans = 0;
        long nl = (long) n;
        while(nl > 1) {
            ans++;
            if(nl % 2 == 0) nl >>= 1;
            else if(nl == 3 || (nl >> 1 & 1) == 0 ) nl--; // n is 3 or ends in 0b01
            else nl++; // ends in 0b11
        }
        return ans;
    }
}

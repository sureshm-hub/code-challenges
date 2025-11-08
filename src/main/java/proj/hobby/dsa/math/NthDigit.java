package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/nth-digit/
 */
public class NthDigit {

    public int findNthDigit(int n) {

        if(n < 10) return n;
        int digit = 1;
        long count = 9;
        int start = 1;

        while(digit * count < n) {
            n -= digit * count;

            ++digit;
            count *= 10;
            start *= 10;
        }

        int seq = start +  (n - 1) / digit ;
        int index = (n - 1) % digit;
        return String.valueOf(seq).charAt(index) - '0';
    }

}

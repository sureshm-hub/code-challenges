package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        int count = 10;// n <= 1 uniq #

        int start = 9;
        for(int i = 2; i <= n; i++) {
            int next = (9 - i + 2);
            start *= next;

            count += start;
        }
        return count;
    }
}

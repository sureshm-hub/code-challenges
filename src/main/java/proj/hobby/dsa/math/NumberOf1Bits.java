package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        String bits = Integer.toString(n, 2);
        int weight = 0;
        for(char c : bits.toCharArray()) {
            if(c == '1') weight++;
        }
        return weight;
    }

}

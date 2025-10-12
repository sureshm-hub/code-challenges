package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/reverse-bits/description
 *
 */
public class ReverseBits {

    public int reverseBits(int n) {

        String bits = Integer.toString(n, 2);

        StringBuilder sb = new StringBuilder(bits);
        sb.reverse();

        while(sb.length() < 32) sb.append("0");

        bits = sb.toString();
        return Integer.parseInt(bits, 2);

    }

}

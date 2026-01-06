package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/reverse-bits/description
 *
 */
public class ReverseBits {

    public int reverseBits(int n) {

        String bits = Integer.toString(n, 2); // msb -> lsb ex: 4 -> 100

        StringBuilder sb = new StringBuilder(bits);
        sb.reverse(); // lsb -> msb  ex: 001

        while(sb.length() < 32) sb.append("0"); // lsb -> msb -> zero padding  ex: 00100000...32 bits

        bits = sb.toString();
        return Integer.parseInt(bits, 2);

    }

}

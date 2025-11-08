package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 *
 */
public class Number2Hexadecimal {

    public String toHex(int num) {
        if (num == 0) return "0";

        final char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(hex[num & 0xf]);
            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}

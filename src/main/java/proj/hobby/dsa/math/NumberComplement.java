package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/number-complement
 *
 */
public class NumberComplement {

    public int findComplement(int num) {
        String s = Integer.toString(num, 2);
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '0') {
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
        }

        String sc = new String(chars);
        return Integer.parseInt(sc, 2);
    }
}

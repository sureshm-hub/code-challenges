package proj.hobby.dsa.strings;

/**
 *
 *  https://leetcode.com/problems/string-to-integer-atoi
 *
 *  Complexity:
 *      Time: O(N) where N is number of digits
 *      Spaec: O(1) to store start, end, mulitplier, pv, resultL & result
 *
 *
 */
public class StringToInteger {

    public int myAtoi(String s) {

        //input validation
        if(s == null || s.trim().isEmpty()) return 0;

        char[] digits = s.trim().toCharArray();

        long result = 0; // for numbers not in Integer.MAX_VALUE or Integer.MIN_VALUE

        int sign = digits[0] == '-' ? -1 : 1;
        int start = (digits[0] == '-' || digits[0] == '+') ? 1 : 0;
        int end = start;
        // find end
        for(int i = start ; i < digits.length; i ++) {
            if(digits[i] < '0' || digits[i] > '9') {
                break;
            }
            end++;
        }

        // adjust for 0
        for(int i = start ; i < end ; i++) {
            if(digits[i] == '0') {
                start++;
            } else{
                break;
            }
        }

        // for large numbers we can return values early
        if(end - start > 10) {
            if(sign == -1) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        for(int i = start; i < end; i ++) {
            if(digits[i] < '0' || digits[i] > '9') {
                break;
            }
            result = (result * 10) + (digits[i]  - '0');
        }

        if(sign == -1 && sign * result < Integer.MIN_VALUE ) {
            return Integer.MIN_VALUE;
        } else if(sign == 1 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int)  (result * sign);
    }

    public static void main(String[] args) {
        StringToInteger s2i = new StringToInteger();
        System.out.println(">> "+s2i.myAtoi("-2147483648"));
        System.out.println(">> "+s2i.myAtoi(null));
        System.out.println(">> "+s2i.myAtoi("   "));
        System.out.println(">> "+s2i.myAtoi("   123"));
        System.out.println(">> "+s2i.myAtoi("   +4123"));
        System.out.println(">> "+s2i.myAtoi("   -412"));
        System.out.println(">> "+s2i.myAtoi("   -042"));
        System.out.println(">> "+s2i.myAtoi("   -412b5"));
        System.out.println(">> "+s2i.myAtoi("   -00000412b5"));
        System.out.println(">> "+s2i.myAtoi("   +00000412b5"));
        System.out.println(">> "+s2i.myAtoi("   00000412b5"));
        System.out.println(">> "+s2i.myAtoi("   +a"));
        System.out.println(">> "+s2i.myAtoi("   -b"));
        System.out.println(">> "+s2i.myAtoi("   c"));
        System.out.println(">> "+s2i.myAtoi("   00000C5"));
        System.out.println(">> "+s2i.myAtoi("   +000009999999999"));
        System.out.println(">> "+s2i.myAtoi("   -0000099999999990"));
        System.out.println(">> "+s2i.myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
    }
}

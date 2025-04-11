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
        if(s == null || s.trim().isEmpty()) {
            return 0; // early exit
        }

        s = s.trim(); // trim leading white spaces
        char[] digits = s.toCharArray();

        // default multiplier & starting digit for strings starting with + or -
        int sign = 1;
        int start = 0;
        if(digits[0] == '+' || digits[0] == '-') {
            start = 1;
        }
        if(digits[0] == '-') {
            sign = -1;
        }

        // find digit's end in String
        int end = start;
        for(int i=start; i < digits.length; i++) {
            if( digits[i] > '9' || digits[i] < '0') {
                break;// digits should be in range 0 - 9
            }
            end++;
        }

        // optimize start to first non zero digit
        for(int i = start ; i < end; i++ ) {
            if(digits[i] == '0') {
                start++;
            } else {
                break;
            }
        }

        // early exit if end-start is a very large number
        if( end - start > 10) {
            if(sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        long resultL = 0L;
        // least value digit on the right
        for( int j = start; j < end; j++) {
            int current = 0;
            if( digits[j] > '9' || digits[j] < '0') {
                break;// digits should be in range 0 - 9
            }

            resultL = resultL* 10 + (digits[j] - '0');

            if(sign == 1 && resultL > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;// boundary condition for MAX
            }
            if(sign == -1 && -resultL < Integer.MIN_VALUE) {
                return  Integer.MIN_VALUE;// boundary condition for MIN
            }

        }
        return (int) resultL * sign;
    }

    public static void main(String[] args) {
        StringToInteger s2i = new StringToInteger();
        System.out.println(">> "+s2i.myAtoi(null));
        System.out.println(">> "+s2i.myAtoi("   "));
        System.out.println(">> "+s2i.myAtoi("   123"));
        System.out.println(">> "+s2i.myAtoi("   +4123"));
        System.out.println(">> "+s2i.myAtoi("   -412"));
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

package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int L = digits.length;
        int first = digits[L-1]+1;
        int carry = first/10;
        if(carry == 0) {
            digits[L-1] += 1;
            return digits;
        }

        digits[L-1] = first%10;
        for(int i =L-2; i >=0 ; i--) {
            int curr = carry+digits[i];
            digits[i] = curr%10;
            carry = curr/10;
        }
        if(carry > 0) {
            int[] sum = new int[L+1];
            System.arraycopy(digits,0,sum,1, digits.length);
            sum[0] = carry;
            return sum;
        }
        return digits;
    }
}

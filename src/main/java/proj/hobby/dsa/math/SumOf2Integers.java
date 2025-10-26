package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/sum-of-two-integers/description/
 *
 */
public class SumOf2Integers {

    public int getSum(int a, int b) {

        int carry = 0, res = 0, mask = 0XFFFFFFFF;

        for(int i =0; i < 32; i++) {
            int a_bit = (a >> i) & 1;
            int b_bit = (b >> i) & 1;

            int cur_bit = a_bit ^ b_bit ^ carry;

            carry = (a_bit + b_bit + carry)  >= 2 ? 1 : 0;

            if(cur_bit != 0) {
                res |= (1 << i);
            }
        }

        if(res > 0X7FFFFFFF) { // if -ve take 2's compliment
            res = ~(res ^ mask);
        }

        return res;
    }
}

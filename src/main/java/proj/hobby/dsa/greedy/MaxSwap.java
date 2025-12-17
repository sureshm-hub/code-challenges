package proj.hobby.dsa.greedy;

/**
 *
 * https://leetcode.com/problems/maximum-swap/description
 *
 */
public class MaxSwap {

    // Greedy Swap
    public int maximumSwap(int num) {

        char[] digits = Integer.toString(num).toCharArray();

        for(int i = 0; i < digits.length; i++) {
            char max = digits[i];
            int idx = i;
            for(int j = i + 1; j < digits.length; j++) {
                if(max <= digits[j]) { // use lower pv for swapping
                    max = digits[j];
                    idx = j;
                }
            }

            if(max > digits[i]) {
                digits[idx] = digits[i];
                digits[i] = max;
                break;
            }
        }

        return Integer.parseInt(new String(digits));

    }
}

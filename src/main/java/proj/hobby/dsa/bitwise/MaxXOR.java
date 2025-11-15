package proj.hobby.dsa.bitwise;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 */
public class MaxXOR {

    public int findMaximumXOR(int[] nums) {

        // int max = Integer.MIN_VALUE;
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = i; j < nums.length; j++) {
        //         max = Math.max(max, nums[i] ^ nums[j]);
        //     }
        // }
        // return max;

        int max = 0;
        int mask = 0;

        for(int bit = 31; bit >= 0; bit--) {

            mask |= (1 << bit);

            // collect prefixes with  mask
            Set<Integer> prefixes = new HashSet<>();
            for(int num : nums) {
                prefixes.add(num  & mask);
            }

            int candidate = max | (1 << bit);

            boolean found = false;

            for(int p : prefixes) {
                if(prefixes.contains(candidate ^ p)) {
                    found = true;
                    break;
                }
            }

            if(found) max = candidate;
        }
        return max;
    }
}

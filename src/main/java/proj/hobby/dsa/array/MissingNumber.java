package proj.hobby.dsa.array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    // use boolean instead of Set<Integer>
    public int missingNumber(int[] nums) {
        int L = nums.length;
        boolean[] seen = new boolean[L + 1];

        for(int num : nums) {
            seen[num] = true;
        }

        for(int i = 0; i < L + 1; i++) {
            if(!seen[i]) return i;
        }

        return -1;
    }

    public int missingNumber2(int[] nums) {

        int n = nums.length;

        Set<Integer> missing = new HashSet<>();

        for(int i = 0; i < n; i++) {
            missing.add(nums[i]);
        }

        for(int i =0; i <= n; i++) {
            if(missing.add(i)) return i;
        }

        return -1;
    }
}

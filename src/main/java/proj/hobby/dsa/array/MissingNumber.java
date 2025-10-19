package proj.hobby.dsa.array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

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

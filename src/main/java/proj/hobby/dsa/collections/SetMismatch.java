package proj.hobby.dsa.collections;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/set-mismatch/description
 */
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= nums.length; i++) {
            set.add(i);
        }
        int dup = 0;
        for(int n : nums) {
            if(!set.remove(n)) dup = n;
        }

        int missing = set.iterator().next();

        return new int[]{dup, missing};
    }
}

package proj.hobby.dsa.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        if(nums.length <= 2) return nums;

        Set<Integer> singles = new HashSet<>();
        for(int n : nums) {
            if(singles.contains(n)) {
                singles.remove(n);
            } else {
                singles.add(n);
            }
        }

        Iterator<Integer> itr = singles.iterator();
        return new int[]{itr.next(), itr.next()};

    }
}

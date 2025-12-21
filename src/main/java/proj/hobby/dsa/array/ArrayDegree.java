package proj.hobby.dsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/degree-of-an-array/description
 */
public class ArrayDegree {

    public int findShortestSubArray(int[] nums) {
        int best = nums.length;
        int degree = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> start = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            start.putIfAbsent(num, i);
            if(count.merge(num, 1, Integer::sum) > degree) {
                degree = count.get(num);
                best = i - start.get(num) + 1;
            } else if(degree == count.get(num)) {
                best = Math.min(best, i - start.get(num) + 1);
            }
        }
        return best;
    }
}

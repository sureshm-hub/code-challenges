package proj.hobby.dsa.collections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/longest-harmonious-subsequence
 *
 */
public class LongestHarmoniousSequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int n : nums)
            counts.merge( n , 1, Integer::sum);

        int max = 0;
        for(int n : counts.keySet()) {
            int  cur = 0;
            if(counts.containsKey(n+1)) {
                cur = counts.get(n) + counts.get(n+1);
            }
            max = Math.max(cur, max);
        }

        return max;
    }

}

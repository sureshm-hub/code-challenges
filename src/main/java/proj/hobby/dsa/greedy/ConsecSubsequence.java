package proj.hobby.dsa.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences
 */
public class ConsecSubsequence {

    // greedy solution: extending prevents leaving behind “dangling” short subsequences that can’t reach length 3.
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> req = new HashMap<>(); // require "n + 1"  to continue

        for(int n : nums) freq.merge( n, 1, Integer::sum);

        for(int n : nums) {
            int fn = freq.getOrDefault(n, 0);
            if(fn == 0) continue;

            // option 1: extend an existing seq at n - 1
            int rn = req.getOrDefault(n, 0);
            if(rn > 0) {
                freq.put(n, fn - 1);
                req.put(n, rn - 1);
                req.merge(n + 1, 1, Integer::sum );
            } else {
                // option 2: start a new  subseq n, n + 1, n + 2
                int fn1 = freq.getOrDefault( n + 1, 0);
                int fn2 = freq.getOrDefault( n + 2, 0);
                if(fn1 > 0 && fn2 > 0) {
                    freq.put(n, fn - 1);
                    freq.put(n + 1, fn1 - 1);
                    freq.put(n + 2, fn2 - 1);
                    req.merge(n + 3, 1, Integer::sum);
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}

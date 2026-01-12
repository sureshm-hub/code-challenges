package proj.hobby.dsa.twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0, r = 0;
        Set<Integer> set = new HashSet<>();
        for(; r < nums.length; r++) {
            if(!set.add(nums[r])) return true; // check duplicates

            if(set.size() > k && l <= r) { // maintain window size
                set.remove(nums[l]);
                l++;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {

        Map<Integer, Integer> numsMap = new HashMap<>();
        int n = nums.length;
        int winStart = 0;
        for(int i = 0; i < n; i++) {
            if(i - winStart > k) {
                int out = nums[winStart++];
                int count = numsMap.get(out) - 1;
                if(count == 0) numsMap.remove(out);
                else numsMap.put(out, count);
            }
            int in = nums[i];
            int val = numsMap.getOrDefault(in, 0);
            if(val >= 1) return true;
            numsMap.put(in, val + 1);
        }
        return false;

    }
}

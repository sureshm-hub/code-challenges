package proj.hobby.dsa.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int longest = 1;

        for(int num : nums) {
            set.add(num);
        }

        for(int x : set) {
            if(!set.contains(x - 1)) { // start of sequence
                int len = 1, curr = x;
                while(set.contains(curr + 1)) {
                    len++;
                    curr++;
                }
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }

}

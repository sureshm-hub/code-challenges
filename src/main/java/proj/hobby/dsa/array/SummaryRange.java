package proj.hobby.dsa.array;

import java.util.ArrayList;
import  java.util.List;

/**
 *
 * https://leetcode.com/problems/summary-ranges/
 *
 */
public class SummaryRange {

    public List<String> summaryRanges(int[] nums) {

        List<String> ranges = new ArrayList<>();

        if(nums == null || nums.length == 0) return ranges;

        int l = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1] + 1) continue;

            addRange(ranges, l, nums[i-1]);
            l = nums[i];
        }
        addRange(ranges, l, nums[nums.length - 1]);
        return ranges;
    }

    private void addRange(List<String> ranges, int l, int r) {
        String range = l == r ? Integer.toString(l) : l + "->" + r ;
        ranges.add(range);
    }

}

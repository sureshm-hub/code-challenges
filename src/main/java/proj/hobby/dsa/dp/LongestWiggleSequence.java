package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/wiggle-subsequence/description/
 */
public class LongestWiggleSequence {

    public int wiggleMaxLength(int[] nums) {

        int lis = 1, lds = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                lis = lds + 1;
            } else if( nums[i] < nums[i - 1]) {
                lds = lis + 1;
            }
        }

        return Math.max(lis, lds);
    }
}

package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description
 *
 */
public class MinMovesEqualNumberII {

    public int minMoves2(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int median = nums[n/2];

        int minMoves = 0;
        for(int num : nums) {
            minMoves += Math.abs(num - median);
        }

        return minMoves;
    }
}

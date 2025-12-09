package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/array-partition/description
 */
public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i = 0; i < nums.length; i += 2) {
            max += Math.min(nums[i], nums[i+1]);
        }
        return max;
    }
}

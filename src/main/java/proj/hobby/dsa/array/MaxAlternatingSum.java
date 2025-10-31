package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/
 */
public class MaxAlternatingSum {

    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) nums[i] *= -1;
        }
        Arrays.sort(nums);

        long max = 0;
        int i = 0 , j = nums.length - 1, mul = 1;

        while (i <= j) {
            if(mul == 1) {
                max += nums[j] * nums[j];
                j--;
            } else {
                max -= nums[i] * nums[i];
                i++;
            }
            mul *= -1;
        }
        return max;
    }

}

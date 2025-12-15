package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description
 *
 */
public class MaxProductOfThreeNums {

    public int maximumProduct(int[] nums) {
        if(nums.length == 3) return nums[0] * nums[1] * nums[2];

        Arrays.sort(nums);
        int L = nums.length;
        int max =  Math.max( nums[L-3] * nums[L-2] * nums[L-1], nums[0] * nums[1] * nums[L-1] );

        if(max < 0) {
            for(int n : nums) {
                if(n == 0) max = 0;
            }
        }
        return max;
    }
}

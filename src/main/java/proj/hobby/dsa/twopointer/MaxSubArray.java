package proj.hobby.dsa.twopointer;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Approach: Sliding Window
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 *
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int i =0; i < nums.length; i++) {
            currSum += nums[i]; // collect the currSum
            if(nums[i] > currSum) { // reset the sliding window as we have moved past the max subarry ending at currEnd
                currSum = nums[i];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

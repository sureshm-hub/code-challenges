package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/house-robber/description/?envType=problem-list-v2&envId=vorkm586
 *
 */
public class HouseRobber {


    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int r0 = nums[0];
        // Note: set r1 to be max of nums[0], nums[1] - intutively simple to handle [2,1,1,2] case
        int r1 = Math.max(nums[0], nums[1]);
        int max = Math.max(r0, r1);
        for(int i = 2; i < nums.length; i++) {
            max = Math.max(r1, r0 + nums[i]);
            r0 = r1;
            r1 = max;
        }
        return max;

        // Approach 2: dynamic programming with array
        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];
        // dp[1] = Math.max(dp[0], nums[1]); // Note: set dp[1] to be max of dp[0] & nums[1] - intutively simple
        // int max = Math.max(dp[0], dp[1]);
        // for(int i = 2; i < nums.length; i++) {
        //     dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        //     max = Math.max(max, dp[i]);
        // }
        // return max;
    }
}

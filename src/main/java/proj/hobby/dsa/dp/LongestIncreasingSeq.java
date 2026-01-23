package proj.hobby.dsa.dp;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSeq {


    // dynamic programming based solution
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i =  1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    // DP state is “best with a specific endpoint/condition”
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {

        int[] cache = new int[nums.length];


        int lis = 0;
        for(int i = 0; i < nums.length; i++ ) {
            lis = Math.max(lis, dfsLIS(nums, i, cache));
        }

        return lis;
    }

    private int dfsLIS(int[] nums, int idx, int[] cache) {

        if(cache[idx] != 0) return cache[idx];

        int lis = 1;
        for(int j = idx + 1; j < nums.length; j++) {
            if(nums[j] > nums[idx]) {
                lis = Math.max(lis, 1 + dfsLIS(nums, j, cache));
            }
        }

        cache[idx] = lis;
        return lis;
    }
}

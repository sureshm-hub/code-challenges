package proj.hobby.dsa.dp;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/partition-equal-subset-sum
 *
 */
public class EqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 == 1) return false;

        int target = sum/2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for(int j = 0; j <= target; j++) {
                if(j < num) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] ||dp[i - 1][j - num];
            }
        }

        return dp[n][target];
    }
}

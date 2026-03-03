package proj.hobby.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/largest-divisible-subset/
 *
 *  DP + predecessor-chain
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);   // dp[i] = length of best subset ending at i
        Arrays.fill(prev, -1); // prev[i] = previous index in chain

        int bestLen = 1, bestEnd = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > bestLen) {
                bestLen = dp[i];
                bestEnd = i;
            }
        }

        // reconstruct
        List<Integer> res = new ArrayList<>(bestLen);
        for(int k = bestEnd; k != -1; k = prev[k]) res.add(nums[k]);
        Collections.reverse(res);
        return res;
    }

}

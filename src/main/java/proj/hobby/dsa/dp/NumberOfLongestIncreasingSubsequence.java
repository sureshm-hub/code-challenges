package proj.hobby.dsa.dp;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence
 *
 */
public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[] length = new int[N];
        int[] count = new int[N];

        Arrays.fill(length, 1);
        Arrays.fill(count, 1);


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if(length[i] == length[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
        }



        // Get # of LIS
        int max = 0, maxCount = 0;
        for(int i = 0; i < N; i++) {
            if(length[i] > max) {
                max = length[i];
                maxCount = count[i];
            } else if(length[i] == max) {
                maxCount += count[i];
            }
        }

        return maxCount;
    }
}

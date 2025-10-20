package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSeq {

    public int lengthOfLIS(int[] nums) {

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

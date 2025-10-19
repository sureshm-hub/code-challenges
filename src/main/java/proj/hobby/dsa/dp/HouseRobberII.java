package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 */
public class HouseRobberII {

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int take = rob(nums, 0, n - 2);
        int skip = rob(nums, 1, n - 1);

        return Math.max(take, skip);
    }

    private int rob(int[] nums, int l , int r) {

        int prev2 = 0, prev1 = 0;
        for(int i = l; i <= r; i++) {
            int take = nums[i] + prev2;
            int skip = prev1;

            int cur = Math.max(take, skip);

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}

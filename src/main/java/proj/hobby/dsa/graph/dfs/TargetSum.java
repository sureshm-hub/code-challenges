package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/target-sum/description
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int[] count = new int[]{0} ;
        dfs(nums, 0, target, count);
        return count[0];
    }

    private void dfs (int[] nums, int idx, int target, int[] count) {

        if(idx == nums.length && target == 0) {
            count[0]++;
            return;
        }

        if(idx >= nums.length) return; // did not reach target & no more nums to add

        dfs(nums, idx + 1, target - nums[idx], count);
        dfs(nums, idx + 1, target + nums[idx], count);
    }
}

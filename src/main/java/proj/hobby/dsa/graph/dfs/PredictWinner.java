package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/predict-the-winner/description
 */
public class PredictWinner {

    public boolean predictTheWinner(int[] nums) {
        int diff = diffScore(nums, 0, nums.length - 1);
        return diff >= 0;
    }

    private int diffScore(int[] nums, int l, int r) {
        if(l == r) return nums[l];

        int left = nums[l] - diffScore(nums, l + 1, r);
        int right = nums[r] - diffScore(nums, l, r - 1);

        return Math.max(left, right);
    }
}

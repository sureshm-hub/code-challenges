package proj.hobby.dsa.prefix;

/**
 *
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSumImmutable {

    private int[] prefix;

    public RangeSumImmutable(int[] nums) {
        prefix = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right+1] - prefix[left];
    }
}

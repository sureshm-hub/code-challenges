package proj.hobby.dsa.binaryTree.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        combSum(nums, target, memo);

        return memo.get(target);
    }

    private int combSum(int[] nums, int target, Map<Integer, Integer> memo) {
        if(target == 0) return 1;

        if(target < 0) return -1;

        if(memo.containsKey(target)) return memo.get(target);

        int count = 0;
        for(int n : nums) {
            int sub = combSum(nums, target - n, memo);
            if(sub > 0) count += sub;
        }
        memo.put(target, count);
        return count;
    }
}

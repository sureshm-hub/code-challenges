package proj.hobby.dsa.graph.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/subsets/description/
 */
public class PowerSubset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        subsetCombo(nums.length, 0, nums, result, curr);
        return result;
    }

    private void subsetCombo(int N, int i, int[] nums, List<List<Integer>> result, List<Integer> curr) {
        if(curr.size() <= N) {
            result.add(new ArrayList<>(curr));
        }

        while(i < N) {
            curr.add(nums[i++]);
            subsetCombo(N, i, nums, result, curr);
            curr.remove(curr.size() - 1);
        }
    }

}

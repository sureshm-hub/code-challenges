package proj.hobby.dsa.graph.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 */
public class PowerSubsetII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        powerSub(nums, 0, sub, result);
        return result;
    }

    private void powerSub(int[] nums, int index, List<Integer> sub, List<List<Integer>> result) {
        result.add(new ArrayList<>(sub));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i-1] == nums[i])  continue;//skip dups at same level
            sub.add(nums[i]);
            powerSub(nums, i+1, sub, result);
            sub.remove(sub.size()-1);
        }
    }
}

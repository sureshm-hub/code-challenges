package proj.hobby.dsa.backtracking;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum(candidates, target, 0, current, result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {

        if(target < 0 || index >= candidates.length) {
            return;
        }

        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(candidates[index]);
        combinationSum(candidates, target - candidates[index], index, current, result);
        current.remove(current.size()-1);

        combinationSum(candidates, target, index+1, current, result);
    }
}

package proj.hobby.dsa;

import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, current, result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {

        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0 || index >= candidates.length) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {

            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }

            if(candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

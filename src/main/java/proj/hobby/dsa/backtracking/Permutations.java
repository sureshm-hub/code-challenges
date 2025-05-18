package proj.hobby.dsa.backtracking;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/permutations/
 *
 * complexity:
 *  time: O(N*N!) - N! permutations and O(N) for copying to result
 *  space: O(N) for current/call-stack + O(N*N!) for collecting result - each of N length & N! total permutations
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)  return result;

        boolean[] used = new boolean[nums.length];

        permute(nums, result, used, new ArrayList());
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, boolean[] used, List<Integer> current) {

        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            permute(nums, result, used, current);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations  solution = new Permutations();
        List<List<Integer>> result = solution.permute(new int[]{1,2,3});
        System.out.println(result);
    }
}

package proj.hobby.dsa.backtracking;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * complexity:
 *  time: O(N*N!)
 *  space: O(N*N!)
 *
 */
public class PermutationsII {



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)  return result;

        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permute(nums, result, used, new ArrayList());
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, boolean[] used, List<Integer> current) {

        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            // if used skip
            if(used[i]) {
                continue;
            }

            // allow only first occurrence of duplicate at each level
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
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
        PermutationsII  solution = new PermutationsII();
        List<List<Integer>> result = solution.permute(new int[]{1,1,3});
        System.out.println(result);
    }

}

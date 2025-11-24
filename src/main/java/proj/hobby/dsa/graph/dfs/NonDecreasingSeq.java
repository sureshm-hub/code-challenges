package proj.hobby.dsa.graph.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/non-decreasing-subsequences/description
 */
public class NonDecreasingSeq {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int idx, LinkedList<Integer> path, List<List<Integer>> res) {
        if(path.size() >= 2 ) res.add(new LinkedList<>(path));

        Set<Integer> used = new HashSet<>();

        for(int i  = idx; i < nums.length; i++) {
            if(used.contains(nums[i])) continue;

            if(path.isEmpty() ||  nums[i] >= path.getLast()) {
                used.add(nums[i]);
                path.addLast(nums[i]);
                dfs(nums, i + 1, path, res);
                path.removeLast();
            }
        }

    }
}

package proj.hobby.dsa.graph.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combination(n, k, 0, result, curr);
        return result;
    }

    private void combination(int n, int k, int i, List<List<Integer>> result, List<Integer> curr) {
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        while(i < n) {
            curr.add(++i);
            combination(n, k, i, result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}

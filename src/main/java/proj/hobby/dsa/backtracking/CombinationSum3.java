package proj.hobby.dsa.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Backtracking
 *
 * Complexity:
 *  Time: O(2^K) - K is count of numbers that should form sum
 *  Space: O(K*M) - K is count of numbers and M is number of combinations that sum up to give n
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, 0, result, new ArrayList<>());
        return result;
    }

    private void combinationSum3(int k, int sum, int curr, List<List<Integer>> result, List<Integer> current) {
        if(k == 0  && sum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(k == 0 || sum < 0)  return; //we have reached k and not found combination or sum can't be formed

        int next = curr+1;

        if(next > 9) return; // we have exhauseted n and not found combination

        // case 1: include next and look for combination
        current.add(next);
        combinationSum3(k-1, sum-next, next, result, current);

        // case 2: exclude next and look for combination
        current.remove(current.size()-1);// backtrack last index
        combinationSum3(k, sum, next, result, current);
    }

    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
        List<List<Integer>> result = cs3.combinationSum3(3, 7);
        System.out.println("Combination Sums: "+result);

        result = cs3.combinationSum3(3, 9);
        System.out.println("Combination Sums: "+result);

        result = cs3.combinationSum3(4, 3);
        System.out.println("Combination Sums: "+result);

        result = cs3.combinationSum3(7, 63);
        System.out.println("Combination Sums: "+result);

        result = cs3.combinationSum3(5, 35);
        System.out.println("Combination Sums: "+result);
    }
}

package proj.hobby.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);   // dp[i] = length of best subset ending at i
        Arrays.fill(prev, -1); // prev[i] = previous index in chain

        int bestLen = 1, bestEnd = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > bestLen) {
                bestLen = dp[i];
                bestEnd = i;
            }
        }

        // reconstruct
        List<Integer> res = new ArrayList<>(bestLen);
        for(int k = bestEnd; k != -1; k = prev[k]) res.add(nums[k]);
        Collections.reverse(res);
        return res;

        // List<List<Integer>> subs = new ArrayList<>();
        // subset(nums, 0, subs);
        // System.out.println(" >> "+subs);

        // int max = 0, index = 0;
        // for(int i  = 0; i < subs.size(); i++) {
        //     if(subs.get(i).size() > max) {
        //         max = subs.get(i).size();
        //         index = i;
        //     }
        // }
        // return subs.get(index);
    }

//    private  void subset(int[] nums, int index, List<List<Integer>> subs) {
//        if(index == nums.length) return;
//
//        int cur = nums[index];
//
//        List<List<Integer>> temp = new ArrayList<>();
//        for(List<Integer> l : subs) {
//            boolean allow = true;
//            for(int i : l) {
//                if (!( i % cur == 0 || cur % i == 0)) {
//                    allow = false;
//                    break;
//                }
//            }
//            if(allow) {
//                List<Integer> l2 = new ArrayList<>(l);
//                l2.add(cur);
//                temp.add(l2);
//            }
//        }
//        subs.addAll(temp);
//        subs.add(new ArrayList<>(List.of(cur)));
//        subset(nums, index + 1, subs);
//    }
}

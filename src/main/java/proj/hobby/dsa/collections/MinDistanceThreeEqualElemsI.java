package proj.hobby.dsa.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/contest/weekly-contest-475/problems/minimum-distance-between-three-equal-elements-i/description/
 */
public class MinDistanceThreeEqualElemsI {

    public int minimumDistance(int[] nums) {

        Map<Integer, int[]> counts = new HashMap<>();
        Map<Integer, List<Integer>> idx  = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            counts.computeIfAbsent( nums[i], k  -> new int[]{0})[0]++;
            idx.computeIfAbsent(nums[i], k ->  new ArrayList<>()).add(i);
        }

        int min = Integer.MAX_VALUE;
        for(int k : counts.keySet()) {
            if(counts.get(k)[0] >= 3) {
                List<Integer> indexes = idx.get(k);
                int abs1 = Math.abs(indexes.get(0) - indexes.get(1));
                int abs2 = Math.abs(indexes.get(2) - indexes.get(1));
                int abs3 = Math.abs(indexes.get(0) - indexes.get(2));
                min = Math.min(abs1 + abs2 + abs3, min);

                for(int i = 3; i < indexes.size(); i++) {
                    int absn2 = Math.abs(indexes.get(i) - indexes.get(i-1));
                    int absn3 = Math.abs(indexes.get(i) - indexes.get(i-2));
                    min = Math.min(abs2 + absn2 + absn3, min);
                    abs2 = absn2;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

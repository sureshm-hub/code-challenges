package proj.hobby.dsa.array;

import java.util.List;

/**
 *
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 */
public class MaxDistanceInArray {

    public int maxDistance(List<List<Integer>> arrays) {
        int max = 0;
        int cMin = 10000;
        int cMax = -10000;
        for(int i = 0; i < arrays.size(); i++) {
            List<Integer> li = arrays.get(i);
            max = Math.max(max, Math.max(li.get(li.size() - 1) - cMin, cMax - li.get(0)));

            cMin = Math.min(cMin, li.get(0));
            cMax = Math.max(cMax, li.get(li.size() - 1));
        }
        return max;
    }
}

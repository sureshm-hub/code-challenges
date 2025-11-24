package proj.hobby.dsa.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/4sum-ii/description/
 */
public class FourSumII {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int count = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for(int a : nums1)
            for(int b : nums2)
                counts.merge( a + b, 1, Integer::sum);

        for(int c : nums3)
            for(int d : nums4)
                count += counts.getOrDefault(-c-d, 0);

        return count;
    }
}

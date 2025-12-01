package proj.hobby.dsa.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/contiguous-array/description/
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        int max = 0;

        if(nums.length == 0) return 0;

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);

        int prefix = 0;
        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i] == 1 ? 1 : -1;
            if(prefixMap.containsKey(prefix)) {
                max = Math.max(max, i - prefixMap.get(prefix)); // keep first occurence for max distance
            } else {
                prefixMap.put(prefix, i);
            }
        }

        return max;

    }
}

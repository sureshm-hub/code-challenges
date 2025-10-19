package proj.hobby.dsa.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int n : nums) {
            int count = countMap.getOrDefault(n, 0);
            countMap.put(n, count + 1);
        }

        int L = nums.length / 3;

        List<Integer> majority = new ArrayList<>();

        for(int n : countMap.keySet()) {
            if(countMap.get(n) > L) majority.add(n);
        }

        return majority;
    }
}

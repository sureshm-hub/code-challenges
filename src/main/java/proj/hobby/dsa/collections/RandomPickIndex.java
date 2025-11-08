package proj.hobby.dsa.collections;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/random-pick-index/
 */
public class RandomPickIndex {

    private final Map<Integer, List<Integer>> idxMap;
    private final Random rand;

    public RandomPickIndex(int[] nums) {
        idxMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            idxMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        rand = new Random();
    }

    public int pick(int target) {
        List<Integer> range = idxMap.get(target);
        if(range == null) {
            throw new IllegalArgumentException(target+" not found");
        }
        if(range.size() == 1) return range.get(0);

        int randIndex = rand.nextInt(0, range.size());
        return range.get(randIndex);
    }
}

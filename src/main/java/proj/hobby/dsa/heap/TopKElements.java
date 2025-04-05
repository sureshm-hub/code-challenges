package proj.hobby.dsa.heap;

import java.util.*;


/**
 * https://leetcode.com/problems/top-k-frequent-elements
 *
 * Complexity:
 *  Time: O(N)  - for forming Hashap + O(NlogK) - for priority Queue
 *  Space: O(N)
 */
public class TopKElements {

    public int[] topKFrequent(int[] nums, int K) {
        Map<Integer, Integer> numFrequency = new HashMap<>();
        for(int num : nums) {
            numFrequency.compute(num, (k, v)  -> v == null ? 1 : v +1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> frequentElems = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> entry  : numFrequency.entrySet()) {
            frequentElems.offer(entry);
            if(frequentElems.size() > K) {
                frequentElems.poll(); // remove least frequent elements
            }
        }

        return frequentElems.stream().mapToInt(Map.Entry::getKey).toArray();
    }

}

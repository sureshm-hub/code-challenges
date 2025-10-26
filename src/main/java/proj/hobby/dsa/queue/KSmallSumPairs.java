package proj.hobby.dsa.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 */
public class KSmallSumPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        record T(int i, int j, int sum){};

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<T> heap = new PriorityQueue<>(Comparator.comparingInt(T::sum));

        for(int i = 0; i < nums1.length; i++) {
            heap.offer(new T(i, 0, nums1[i] + nums2[0]));
        }

        while(result.size() < k && !heap.isEmpty()) {
            T min = heap.poll();
            int i = min.i();
            int j = min.j();
            result.add(List.of(nums1[i], nums2[j]));

            if(j + 1 < nums2.length)
                heap.offer(new T(i, j + 1, nums1[i] + nums2[j+1]));
        }
        return result;
    }
}

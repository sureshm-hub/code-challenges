package proj.hobby.dsa.queue;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/maximum-product-of-three-elements-after-one-replacement/description/
 */
public class MaxProductOf3Elements {

    public long maxProduct(int[] nums) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for(int n : nums) {
            heap.offer((long)Math.abs(n));
            if(heap.size() > 3)  heap.poll();
        }
        heap.poll();// discard the lowest
        long max =  heap.poll() * heap.poll() * 100_000l;
        return max;
    }
}

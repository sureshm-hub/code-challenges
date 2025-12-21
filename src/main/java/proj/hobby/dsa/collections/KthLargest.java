package proj.hobby.dsa.collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description
 *
 */
public class KthLargest {

    private int k;
    private Queue<Integer> heap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            heapify(num);
        }
    }

    public int add(int val) {
        heapify(val);
        return heap.peek();
    }

    private void heapify(int val) {
        heap.offer(val);
        if(heap.size() > k) {
            heap.poll();
        }
    }
}

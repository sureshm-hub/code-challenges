package proj.hobby.dsa.heap;

import java.util.*;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Priority Queue
 *
 * Complexity:
 *  Time: O(N logK)
 *  Space: O(K) - Kth Largest element
 *
 *
 */
public class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for(int num : nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();// remove the smallest element
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        KthLargest kth = new KthLargest();
        System.out.println("Kth Largest: "+kth.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println("Kth Largest: "+kth.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}

package proj.hobby.dsa.heap;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: back operations by Hashset
 *
 * Complexity:
 *  Time:
 *      popSmallest: O(Log N) if Heap is used or O(1) - N number of elements in heap
 *      addBack:  O(Log N) heap insertion
 *
 *  Space: O(N) - N number of elements in heap
 *
 *
 */

public class SmallestInfiniteSet {

    private int current;
    private Queue<Integer> minHeap;
    private Set<Integer> poppedSet;

    public SmallestInfiniteSet() {
        current = 1;
        minHeap = new PriorityQueue<>();
        poppedSet = new HashSet<>();
    }

    public int popSmallest() {
        if(!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            poppedSet.remove(smallest);
            return smallest;
        }
        return current++;
    }

    public void addBack(int num) {
        if(num < current && poppedSet.add(num)) {
            minHeap.offer(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        System.out.println("pop smallest: "+smallestInfiniteSet.popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
        System.out.println("pop smallest: "+smallestInfiniteSet.popSmallest()); // return 2, and remove it from the set.
        System.out.println("pop smallest: "+smallestInfiniteSet.popSmallest()); // return 3, and remove it from the set.
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        System.out.println("pop smallest: "+smallestInfiniteSet.popSmallest()); // return 1, since 1 was added back to the set and
        // is the smallest number, and remove it from the set.
        System.out.println("pop smallest: "+smallestInfiniteSet.popSmallest()); // return 4, and remove it from the set.
        System.out.println("pop smallest: "+smallestInfiniteSet.popSmallest()); // return 5, and remove it from the set.
    }
}

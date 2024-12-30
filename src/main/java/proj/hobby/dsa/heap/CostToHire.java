package proj.hobby.dsa.heap;

import java.util.*;

/**
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Priority Queue to hold candidates in minHeap
 *
 * Complexity:
 *  Time: O(N Log N + K log N) - N Candidates & K rounds
 *  Space: O(N) - store N candidates in min heap
 *
 */
public class CostToHire {

    public long totalCost(int[] costs, int k, int candidates) {

        // priority Queue to compare candidates with the lowest cost then lowest index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] == b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
        int left = candidates-1, right=costs.length-candidates; //left, right to track indexes
        for(int i = 0; i <= left && i < costs.length; i++) {
            minHeap.offer(new int[]{costs[i], i});
        }
        for(int i = Math.max(right,left+1); i < costs.length; i++) {
            minHeap.offer(new int[]{costs[i], i});
        }

        long totalCost = 0;
        while(k > 0 && !minHeap.isEmpty()) {
            int[] selected = minHeap.poll();
            totalCost += selected[0];
            int next = -1;
            if(selected[1] <= left && left + 1 < costs.length && left + 1 < right){
                next = ++left;
            } else if(selected[1] >= right && right - 1 >= 0 && right -1 > left) {
                next = --right;
            }
            if(next != -1) {
                minHeap.offer(new int[]{costs[next],next});
            }
            k--;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        CostToHire cth = new CostToHire();
        System.out.println("Cost To Hire workers: "+cth.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
        System.out.println("Cost To Hire workers: "+cth.totalCost(new int[]{1,2,4,1}, 3, 3));
        System.out.println("Cost To Hire workers: "+cth.totalCost(new int[]{1,2,4,1}, 3, 10));
        System.out.println("Cost To Hire workers: "+cth.totalCost(new int[]{5}, 1, 1));
        System.out.println("===");
        System.out.println("Cost To Hire workers: "+cth.totalCost(new int[]{28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34}, 32, 12));
    }
}

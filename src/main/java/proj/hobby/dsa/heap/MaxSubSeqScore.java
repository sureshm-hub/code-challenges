package proj.hobby.dsa.heap;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-subsequence-score/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Analysis: pair sorting and Iteration with minHeap to keep top k elements
 *      v1: Brute Force Solution
 *
 * Complexity:
 *   Time: O(NlogN + N log K) - sorting pairs and N * log K for calculating score
 *   Space: O(N) - paired array
 *
 *  V1 (Brute Force Solution):
 *      TIme: O(2^N) - N is number of elements
 *      Space: O(1) - call hierarchy for min, sum and index
 *
 */
public class MaxSubSeqScore {

   public long maxScore(int[] nums1, int[] nums2, int k) {

        // pair nums1 & nums2 by index and sort by nums2 in descending order
        int n = nums1.length;
        int[][] paired = new int[n][2];

        for(int i =0; i < n; i++ ) {
            paired[i][0] = nums2[i];
            paired[i][1] = nums1[i];
        }
        Arrays.sort(paired, (a,b) -> Integer.compare(b[0],a[0]));

        // min heap to store largest k elements  of nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long currentSum = 0, maxScore =Integer.MIN_VALUE;

        // Iterate through sorted pairs
        for(int i =0 ; i < n; i++) {
            int num1 = paired[i][1];
            int num2 = paired[i][0];

            // add current element to heap and update sum
            minHeap.offer(num1);
            currentSum += num1;

            // when heap size is K calculate score
            if(minHeap.size() == k) {
                maxScore = Math.max(currentSum * num2, maxScore);
                currentSum -= minHeap.poll(); // remove the smallest value to make roomt for more elements
            }
        }
        return maxScore;
    }

    public long maxScoreV1(int[] nums1, int[] nums2, int k) {
        return dfsV1(nums1, nums2, k, Integer.MAX_VALUE, 0, 0);

    }

    private int dfsV1(int[] nums1, int[] nums2, int k, int min,int sum, int index) {
        if(k == 0) { // base case
            return min * sum;
        }

        if(index == nums1.length) { //base case: we reached end of the array
            return Integer.MIN_VALUE;
        }

        // include current element from the subseq
        int include = dfsV1(nums1, nums2, k-1,Math.min(min, nums2[index]), sum+nums1[index],index+1);
        // exclude current element from the subseq
        int exclude = dfsV1(nums1, nums2, k, min, sum, index+1);

        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        MaxSubSeqScore mss = new MaxSubSeqScore();
        System.out.println("Max Sub Sequence Score: "+mss.maxScore(new int[]{1,3,3,2},new int[]{2,1,3,4}, 3));
        System.out.println("Max Sub Sequence Score: "+mss.maxScoreV1(new int[]{1,3,3,2},new int[]{2,1,3,4}, 3));
        System.out.println("Max Sub Sequence Score: "+mss.maxScore(new int[]{4,2,3,1,1},new int[]{7,5,10,9,6}, 1));
        System.out.println("Max Sub Sequence Score: "+mss.maxScoreV1(new int[]{4,2,3,1,1},new int[]{7,5,10,9,6}, 1));
        System.out.println("Max Sub Sequence Score: "+mss.maxScore(new int[]{4,2,3,1,1},new int[]{6,5,8,9,6}, 1));
        System.out.println("Max Sub Sequence Score: "+mss.maxScore(new int[]{4,2,1,3,1},new int[]{6,5,10,9,6}, 2));
    }
}

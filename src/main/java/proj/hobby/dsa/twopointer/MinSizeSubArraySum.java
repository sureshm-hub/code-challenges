package proj.hobby.dsa.twopointer;

/**

 Problem:
 https://leetcode.com/problems/minimum-size-subarray-sum/description/

 Complexity: O(N)

 */
public class MinSizeSubArraySum {

    /**
     *
     * Sliding window pattern:
     *      - No Extra Scan for invalid cases
     *      - Single pass control flow
     *      - cleaner edge case handing
     *      - Algo: for loop to expand window, inner while loop to shrink & collect valid answer.
     *      Note: default min appropriately
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, r = 0, sum = 0, min = Integer.MAX_VALUE;

        for(; r < nums.length; r++) {
            sum += nums[r];

            while(sum >= target && l <= r) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int target, int[] nums) {


        // NOTE: Extra loop not needed
        int sum = 0;
        for(int n : nums) {
            if(n == target) return 1; // best case
            sum += n;
        }

        if(sum < target) return 0; // no solution

        int l = 0, r = 0;
        int total = 0;
        int min = nums.length;
        while(r < nums.length) {
            while(total < target && r < nums.length) { // NOTE: r < nums.length is redundant
                total += nums[r];
                r++; // NOTE: r advancement is confusing
            }
            while(total >= target && l < r) {// NOTE: 2 while loops is confusing
                int cur = r - l;// NOTE: as r++ advancement happens
                min = Math.min(min, cur);
                total -= nums[l];
                l++;
            }
        }
        return min;

    }

    public int minSubArrayLen3(int target, int[] nums) {
        int start =0, end =0, sum =0;
        int min = Integer.MAX_VALUE;
        for(;end<nums.length;end++) {
           sum += nums[end];
           if(sum >= target) {
               min = Math.min(min, end-start+1);
               for(;start <= end; ) {
                   if(sum >= target) {
                       min = Math.min(min, end-start+1);
                       sum -= nums[start];
                       //Note: Moving starting pointer in sliding window
                       start++;
                   }  else {
                       break;
                   }
               }
           }
        }
        if(min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;
    }

}

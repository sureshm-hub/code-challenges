package proj.hobby.dsa;

/**

 Problem:
    https://leetcode.com/problems/minimum-size-subarray-sum/submissions/1408145813/?envType=study-plan-v2&envId=top-interview-150

 Complexity: O(N)

 */
public class MinSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
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

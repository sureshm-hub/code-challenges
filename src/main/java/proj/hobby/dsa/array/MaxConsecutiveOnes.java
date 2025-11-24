package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/max-consecutive-ones
 *
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consec = 0;
        for( int  i  = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                consec++;
            }
            if(nums[i] == 0) {
                max = Math.max(max, consec);
                consec = 0;
            }
        }
        max = Math.max(max, consec); // last consec
        return max;
    }

}

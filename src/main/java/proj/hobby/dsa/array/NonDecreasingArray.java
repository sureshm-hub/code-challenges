package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/non-decreasing-array/description/
 *
 */
public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int decr = 0; // # of elems to decrease to make nums non decreasing
        int N = nums.length;

        for(int i = 1; i < N; i++) {
            if(nums[i] < nums[i-1]) {
                decr++;
                if(decr > 1) return false;

                // Greedy decrease
                if(i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i-1] = nums[i]; // option 1: lower nums[i -1]
                } else {
                    nums[i] = nums[i - 1]; // option 2: raise nums[i]
                }
            }
        }
        return decr <= 1;
    }
}

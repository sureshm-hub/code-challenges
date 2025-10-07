package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 */
public class MinInRotated {

    public int findMin(int[] nums) {

        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

}

package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Uses Binary Search (Lower Bound style) to find min pivot
 *      - either [lo, mid] or [mid, hi] is fully sorted
 *      - check if mid to hi is unsorted => nums[mid] > nums[hi]
 *          - if yes continue searching (mid, hi]
 *          - if no continue searching [lo, mid]
 *      - while(lo < hi) when loop ends lo == hi & they will point to first element of the rotated part
 *      - ,i.e, min in the rotated sorted array
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

package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class InsertIndex {

    public int searchInsert(int[] nums, int target) {

        int lo = 0, hi = nums.length;                 // [lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

}

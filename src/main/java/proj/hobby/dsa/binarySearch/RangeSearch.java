package proj.hobby.dsa.binarySearch;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class RangeSearch {

    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0) return new int[]{-1, -1};

        int lo = 0, hi = nums.length;

        // find lower bound for target
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            //System.out.println("[lo, mid, hi]: ["+lo+", "+mid+", "+hi+"]");
            if(nums[mid] < target) lo = mid+1;
            else hi = mid;
        }
        if(lo == nums.length || nums[lo] != target) return new int[]{-1, -1}; // no solution as we didn't find target
        //System.out.println("====");

        int left = lo;
        lo = 0;
        hi = nums.length;

        //find first index where nums[idx] > target. If none return length
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            //System.out.println("[lo, mid, hi]: ["+lo+", "+mid+", "+hi+"]");
            if(nums[mid] <= target) lo = mid+1;
            else hi = mid;
        }

        return new int[]{left, lo-1};
    }

}

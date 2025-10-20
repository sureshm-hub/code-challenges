package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindDuplicateNum {

    public int findDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) /2;

            int count = 0;
            for(int x : nums) if(x <= mid) count++;

            if(count > mid) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

}

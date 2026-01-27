package proj.hobby.dsa.collections;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * Default splice won't work: If you just take the second half and interleave it forward with the first half, duplicates
 * can sit next to each other and break the < > < > pattern.
 */
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int mid = (n - 1)/2; // last index of bottom half; n/2  -> floor division won't work for even lengthed arrays
        int hi = n - 1; // last index of upper half

        int[] temp = new int[n];
        int k = 0;
        for(int i = mid; i >= 0; i --) {
            temp[k] = nums[i];
            k += 2;
        }

        k = 1;
        for(int i = hi; i > mid; i--) {
            temp[k] = nums[i];
            k += 2;
            if(k >= n) break;
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }
}

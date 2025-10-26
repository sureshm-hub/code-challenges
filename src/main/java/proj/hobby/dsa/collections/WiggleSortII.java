package proj.hobby.dsa.collections;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 */
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int mid = (n - 1)/2;
        int hi = n - 1;

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

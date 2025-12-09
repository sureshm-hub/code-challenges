package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description
 *
 */
public class ShortestUnsorted {

    public int findUnsortedSubarray(int[] nums) {
        int N = nums.length;
        int[] temp = new int[N];
        System.arraycopy(nums, 0, temp, 0, N);
        Arrays.sort(temp);

        int l = 0, r = N - 1;
        while( l <= r ) {
            if(nums[l] == temp[l]) {
                l++;
            } else  break;
        }

        if(l >= r) return 0; // nums is sorted

        while(r >= l) {
            if(nums[r] == temp[r]) {
                r--;
            } else break;
        }

        return r - l + 1;
    }
}

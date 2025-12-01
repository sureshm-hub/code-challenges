package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description
 */
public class KDiffPairs {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int l =0, r = 1;
        int ks = 0; // unique k-diff pairs count
        while(r < nums.length) {
            int diff = nums[r]-nums[l];
            if(diff < k) {
                r++;
            } else if (diff > k) {
                l++;
            } else {
                if((l == 0) || (nums[l-1] != nums[l]))  { // check to avoid dups
                    ks++;// found a pair
                }
                r++;
                l++;
            }
            if(l == r) r++; // i != j so keep incrementing r when l catches up
        }

        return ks;
    }

}



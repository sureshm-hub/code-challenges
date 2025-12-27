package proj.hobby.dsa.twopointer;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
 *
 */
public class MaxNumberKPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i =0, j = nums.length-1;
        int ops = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if( sum == k) {
                ops++;
                i++;
                j--;
            }
            if(sum > k) {
                j--;
            }
            if(sum < k) {
                i++;
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        MaxNumberKPairs mnk = new MaxNumberKPairs();
        int i = mnk.maxOperations(new int[]{1, 2, 3, 4}, 5);
        System.out.println("Max Number KPairs: "+i);

        mnk = new MaxNumberKPairs();
        i = mnk.maxOperations(new int[]{3,1, 3, 4, 3}, 6);
        System.out.println("Max Number KPairs: "+i);
    }
}

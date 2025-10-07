package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/rotate-array
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        k %= n;

        if(k == 0) return;

        int[] temp = new int[nums.length];

        for(int i = 0, j = k; i < n; i++, j++) {
            temp[j] = nums[i];
            if(j == n - 1) j = -1; // reset j
        }

        for(int i = 0; i < n; i++) nums[i] = temp[i];
    }

}

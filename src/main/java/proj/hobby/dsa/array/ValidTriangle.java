package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/valid-triangle-number/description
 */
public class ValidTriangle {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[k] < nums[i] + nums[j]) count++;
                    else break;// reached end of valid triangles
                }
            }
        }

        return count;
    }
}

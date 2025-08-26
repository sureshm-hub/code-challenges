package proj.hobby.dsa.twopointer;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/3sum-closest/
 *
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println("nums: "+Arrays.toString(nums));
        int result =nums[0]+nums[1]+nums[2];
        int min = Math.abs(target-result);

        for(int i=0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    int curr = nums[i]+nums[j]+nums[k];
                    int currMin = Math.abs(target-curr);
                    if(currMin < min) {
                        result = curr;
                        min = currMin;
                    }
                }
            }
        }
        return result;
    }
}

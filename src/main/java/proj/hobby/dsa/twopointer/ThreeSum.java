package proj.hobby.dsa.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 Problem:
    https://leetcode.com/problems/3sum/

 Clarifying Questions:
     - Are they sorted?
     - and they can be +ve or -ve ??

 Example:
    Input: {1,2,3, -3, 0}
    Output: {{1,2,-3},{3,-3,0}}

 Complexity:
     Time: O(N log N) + O(N^2) ~ O(N^2)
     Space: O(N)
**/

public class ThreeSum {

    public List<List<Integer>> tripletSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length-2 ; i++) {
            int target = -nums[i];// target
            int left = i+1;
            int right = nums.length-1;
            if( i > 0 && nums[i] == nums[i-1])  continue;//skip to avoid duplicates

            while(left<right) {

                if(nums[left]+nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // move past duplicates
                    while(left < right && nums[left]  == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                } else if(nums[left]+nums[right] > target) {
                    right--;
                } else if(nums[left]+nums[right] < target) {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum tripletSum = new ThreeSum();
        List<List<Integer>> solutions = tripletSum.tripletSum(new int[]{-1,0,1,2,-1,-4});
        solutions.forEach( x -> System.out.println(x));

        System.out.println("=====");

        solutions = tripletSum.tripletSum(new int[]{-1,0,1,0,-1,0,0,0,1});
        solutions.forEach( x -> System.out.println(x));
    }
}

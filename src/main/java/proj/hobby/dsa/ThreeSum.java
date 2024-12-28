package proj.hobby.dsa;

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

 Pseduo Code:
     solve:
         sort(nums)
         List<int[]> result = new ArrayList<>();
         for 0 -> nums.length
             int[] twoSumResult = twoSum(-1* nums(index), index, nums)
             if(twoSumResult != null)
                result.add({nums(index), twoSumResult[0], twoSumResult[1]});
         return result;


     twoSum(target, i, nums):
         START = i+1
         END = last
         currentTarget = START + END;
         while(START < END)
             if( currentTarget > target)
                 END--;
             elseif(currentTarget < target)
                 START++;
             else
                 return {START, END};
         return null;

 Complexity:
     O(N log N) + O(N^2)
     ~ O(N^2)
**/

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length-1; i++) {
            List<Integer> twoSumResult = twoSum(-1 * nums[i], i, nums);
            if(twoSumResult != null) {
                // Note: triplets is a List of List
                List<Integer> triplets = Arrays.asList(nums[i], twoSumResult.get(0), twoSumResult.get(1));
                result.add(triplets);
            }
        }
        return result;
    }

    private List<Integer> twoSum(int target, int i, int[] nums) {
        int start = i+1;
        int end = nums.length-1;
        while(start < end) {
            int currentTarget = nums[start] + nums[end];
            if(currentTarget < target) {
                start++;
            } else if(currentTarget > target) {
                end--;
            } else {
                return Arrays.asList(nums[start] , nums[end]);
            }
        }
        return null;
    }
}

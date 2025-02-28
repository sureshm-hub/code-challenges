package proj.hobby.dsa.maps;

import java.util.*;

/**

 Problem: https://leetcode.com/problems/two-sum/

 Clarifying Q's:
     - is the input  array sorted? N
            - if Y we can use two pointers to save space
     - can the nums in array be nagative? Y
     - can the nums in array be repeated? Y

 Example:
     {1,2,-1,4} target=6
     output: {1,3}  -- indices

 HashMap:
    use a hashmap to store the index for each number
    Complexity:
        Time: O(N)
        Space: O(N)

 2 Pointer:
     only works if nums are already sorted
     Performance:
         Time: O(N)
         Space: O(1)
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // indexMap values are List<Integers> to allow duplicates
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for(int i =0 ; i < nums.length; i++) {
            List<Integer> indexList = indexMap.get(nums[i]);
            if(indexList == null) {
                indexList = new ArrayList<>();
                indexList.add(i);
                indexMap.put(nums[i], indexList);
            } else {
                indexList.add(i);
            }
        }

        for(int i = 0 ; i < nums.length; i++) {
            List<Integer> indexList = indexMap.get(target-nums[i]);
            if(indexList != null) {
                for(int index : indexList) {
                    if(index != i) {
                        return new int[]{i, index};
                    }
                }
            }
        }
        return null;
    }

    /**
     * Note: only works if nums are already sorted
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumConstantSpace(int[] nums, int target) {
        Arrays.sort(nums);
        int startIndex = 0;
        int endIndex = nums.length-1;
        while(startIndex < endIndex) {
            int currentTarget = nums[startIndex] + nums[endIndex];
            if(currentTarget < target) {
                startIndex++;
            } else if (currentTarget > target) {
                endIndex--;
            } else {
                return new int[] {startIndex, endIndex};
            }
        }
        return null;
    }

}

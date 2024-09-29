package proj.hobby.leet;

import java.util.*;

/**

 Problem:
    https://leetcode.com/problems/two-sum/

 Clarifying Q's:
     - is the input  array sorted? N
     - can the nums in array be nagative? Y
     - can the nums in array be repeated? Y

 Example:
     {1,2,-1,4} target=6
     output: {1,3}  -- indices

 HashMap:

 2 Pointer:
     use a hashmap to store the index for each number
     sort the numbers
     initialize 2 pointers to START, END
     loop till START  index > END index
         if sum of 2 pointers > target reduce the index of END pointer by 1
         else if sum of 2 pointers < target increase the index of START pointer by 1
         else return indexes of START, END from hashmap

 Performance:
     O(N) + O(N log N) + O(N)
     ~ O (N log N)

 **/
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {
        // Note:  when numbers repeat put overrides previous index
        // hence HashMap of <Integer, Integer> won't work
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
                int[] solution = new int[2];
                if(nums[startIndex] == nums[endIndex]) {
                    List<Integer> indexList = indexMap.get(nums[startIndex]);
                    solution[0] = indexList.get(0);
                    solution[1] = indexList.get(1);
                } else {
                    solution[0] = indexMap.get(nums[startIndex]).get(0);
                    solution[1] = indexMap.get(nums[endIndex]).get(0);
                }
                return solution;
            }
        }
        return null;
    }

}

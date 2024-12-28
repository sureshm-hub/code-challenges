package proj.hobby.dsa.maps;

import java.util.*;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Java Collection Classes
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 *
 */
public class ArrayDifference {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int num: nums2){
            set2.add(num);
        }

        List<Integer> distinct1 = new ArrayList<>(set1);
        distinct1.removeAll(set2);

        List<Integer> distinct2 = new ArrayList<>(set2);
        distinct2.removeAll(set1);
        result.add(distinct1);
        result.add(distinct2);

        return result;
    }

    public static void main(String[] args) {
        ArrayDifference ad  = new ArrayDifference();
        List<List<Integer>> result = ad.findDifference(new int[]{1,2,3}, new int[]{2,4,6});
        System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println("=====");
        result = ad.findDifference(new int[]{2,2,3,3}, new int[]{2,4,3,4,6,6});
        System.out.println(result.get(0));
        System.out.println(result.get(1));
    }
}

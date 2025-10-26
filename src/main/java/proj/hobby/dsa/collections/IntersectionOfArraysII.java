package proj.hobby.dsa.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 */
public class IntersectionOfArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> intsec = new ArrayList<>();

        int i =0, j =0;
        while( i < nums1.length && j < nums2.length ) {

            if(nums1[i] < nums2[j]) i++;
            else if(nums2[j] < nums1[i]) j++;
            else {
                intsec.add(nums1[i]);
                i++;
                j++;
            }
        }
        return intsec.stream().mapToInt(Integer::intValue).toArray();
    }
}

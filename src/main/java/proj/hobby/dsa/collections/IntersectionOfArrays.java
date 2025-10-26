package proj.hobby.dsa.collections;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intsec = new HashSet<>();
        Set<Integer> other = new HashSet<>();
        for(int n : nums1) other.add(n);
        for(int n : nums2) {
            if(other.contains(n)) intsec.add(n);
        }
        return intsec.stream().mapToInt(Integer::intValue).toArray();
    }
}

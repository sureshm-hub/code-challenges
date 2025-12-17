package proj.hobby.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/find-k-closest-elements
 *
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, final int x) {
        Comparator<Integer> byAbsDist = (a, b) -> Math.abs(x - a) - Math.abs(x - b);
        Comparator<Integer> byAbsDistbyInt = byAbsDist.thenComparingInt(a -> a);
        // Option 2:
        // Comparator<Integer> byAbsbyNatural = byAbsDist.thenComparing(Comparator.naturalOrder());

        Integer[] arrInt = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) arrInt[i] = arr[i];

        Arrays.sort(arrInt, byAbsDistbyInt);

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) res.add(arrInt[i]);

        res.sort(Comparator.naturalOrder());

        return res;
    }
}

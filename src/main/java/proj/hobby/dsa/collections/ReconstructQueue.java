package proj.hobby.dsa.collections;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 *
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, Comparator.comparingInt( (int[] k) -> -k[0]) // tallest first
                .thenComparingInt( (int[] k) -> k[1])); // followed by  order

        List<int[]> list = new ArrayList<>();
        for(int[] p : people) {
            list.add(p[1], p);
        }

        return list.stream().toArray(int[][] :: new);
    }
}

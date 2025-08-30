package proj.hobby.dsa.array;
import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt( i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int L = intervals.length;

        int[] curr = intervals[0];
        for (int i = 1; i<L; i++) {
            int[] next = intervals[i];
            if(next[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else{
                result.add(curr);
                curr = next;
            }
        }
        result.add(curr);
        return result.stream().toArray(int[][]::new);
    }
}

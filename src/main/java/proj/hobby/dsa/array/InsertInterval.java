package proj.hobby.dsa.array;
import java.util.*;

/**
 *
 * https://leetcode.com/problems/insert-interval/
 *
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int N = intervals.length;
        List<int[]> result = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        int i =0;

        // 1. insert all before new
        for(;i < N && intervals[i][1] < start; i++) {
            result.add(intervals[i]);
        }

        // 2. merge all overlappign with new
        for(;i < N &&  intervals[i][0] <= end ;i++) {
            newInterval[0] = Math.min(intervals[i][0],  newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],  newInterval[1]);
        }
        result.add(newInterval);

        // 3. append all after new
        for(; i < N ; i++) {
            result.add(intervals[i]);
        }
        return result.stream().toArray(int[][]::new);
    }

}

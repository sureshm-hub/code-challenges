package proj.hobby.dsa.intervals;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/non-overlapping-intervals/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: This solution applies a greedy algorithm that makes locally optimal choices to achieve globally optimal
 * result. The key idea is to remove the minimum number of overlaps by maximizing the number of non-overlapping
 * intervals. For this we "sort intervals by end time" and this ensures we priortize intervals that finish earlier,
 * leaving room for subsequent intervals
 *
 * Complexity:
 *  Time: O(NlogN)
 *  Space: O(1)
 *
 */
public class NonOverlapping {

    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals == null || intervals.length == 0) return 0; //for empty intervals no overlap

        //Arrays.sort(intervals, (o1, o2) -> (o1[1] == o2[1] ?  Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
        Arrays.sort(intervals, Comparator.comparingInt( o -> o[1]));
        int count = 1, end = intervals[0][1];
        for(int i =1; i < intervals.length; i++) {
            if(intervals[i][0] >= end) { // count intervals without overalp
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        NonOverlapping inter = new NonOverlapping();
        System.out.println("Remove Overlaps: "+inter.eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
        System.out.println("Remove Overlaps: "+inter.eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}));
        System.out.println("Remove Overlaps: "+inter.eraseOverlapIntervals(new int[][] {{1,2},{2,3}}));
    }
}

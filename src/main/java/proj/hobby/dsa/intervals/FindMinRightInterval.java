package proj.hobby.dsa.intervals;

/**
 *
 * https://leetcode.com/problems/find-right-interval/description/
 */
public class FindMinRightInterval {

    public int[] findRightInterval(int[][] intervals) {

        int M = intervals.length;
        int[] res = new int[M];

        for(int i = 0; i < M; i++) {

            int idx = M + 10; // safe max
            int end = intervals[i][1];
            int best = Integer.MAX_VALUE; // best right start so far

            for(int j = 0; j < M; j++) {

                int start =  intervals[j][0];
                if(end <= start && best > start) {
                    idx = j;
                    best = start;
                }
            }
            res[i] = idx == M + 10 ? -1 : idx;
        }

        return res;
    }
}

package proj.hobby.dsa.array;

import java.util.List;

/**
 *
 * https://leetcode.com/problems/minimum-time-difference
 *
 */
public class MinTimeDifference {

    public int findMinDifference(List<String> timePoints) {

        // Comparator<String> byHour = Comparator.comparingInt(a -> Integer.parseInt(a.split(":")[0]));
        // Comparator<String> byHourByMin = byHour.thenComparing(Comparator.comparingInt(a -> Integer.parseInt(a.split(":")[1])));
        // timePoints.sort(byHourByMin);



        int[] mins = timePoints.stream()
                .mapToInt(a -> (Integer.parseInt(a.split(":")[0]) * 60 )+  Integer.parseInt(a.split(":")[1]))
                .sorted()
                .toArray();
        // Arrays.sort(mins);
        int N = mins.length;
        int start = 24 * 60;
        int min = start + mins[0] - mins[N-1];
        for(int i = 1; i < N; i++) {
            min = Math.min(min, mins[i] -mins[i-1]);
        }
        return min;
    }
}

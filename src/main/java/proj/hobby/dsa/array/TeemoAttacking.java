package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/teemo-attacking/description
 */
public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if(duration == 0) return 0;

        int N = timeSeries.length;
        if(N == 1) return duration;

        int intervals = N * duration; // Max Possible

        for(int i = 0; i < N - 1; i++ ) {
            int cur = timeSeries[i + 1] - timeSeries[i];
            if( duration > cur) {
                intervals -= (duration - cur); // we lost this much poison
            }
        }

        return intervals;
    }
}

package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/contest/weekly-contest-474/problems/minimum-time-to-complete-all-deliveries/description/
 */
public class MinimumTimeToComplete {

    public long minimumTime(int[] d, int[] r) {
        long D1 = d[0] , D2 = d[1], R1 = r[0], R2 = r[1];
        long L = lcm(R1, R2);

        long lo = 0, hi = (D1 + D2) * Math.max(R1, R2) + 5; // generous upper bound
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (can(mid, D1, D2, R1, R2, L)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean can(long T, long d1, long d2, long r1, long r2, long L) {
        long a1 = T - T / r1;   // hours available for drone 1
        long a2 = T - T / r2;   // hours available for drone 2
        long u  = T - T / L;    // hours available to at least one
        if (d1 > a1 || d2 > a2) return false;
        return d1 + d2 <= u;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b; b = t;
        }
        return a;
    }
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b; // order avoids overflow
    }
}

package proj.hobby.dsa.math;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/super-ugly-number/description/
 *
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(l -> l[0]));

        int[] uns = new int[n];
        uns[0] = 1;

        for(int p : primes) {
            heap.offer(new long[]{p, 0, p});// val, index, prime
        }

        int i = 1;
        while(i < n) {
            long[] cur  = heap.poll();
            long val = cur[0];
            int idx = (int) cur[1];
            int p = (int) cur[2];

            if(val != uns[i - 1]) {
                uns[i++] = (int) val;
            }

            long nextVal = (long) uns[idx + 1] * p;
            heap.offer(new long[]{nextVal, idx + 1, p});
        }
        return uns[n - 1];
    }
}

package proj.hobby.dsa.queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/ugly-number-ii/
 *
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {

        long[] primes = new long[]{2, 3, 5};

        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();

        pq.add(1L);
        seen.add(1L);

        long val = 1L;
        for(int i = 0; i < n; i++) {
            val = pq.poll();
            for(long p : primes) {
                long next = val * p;
                if(seen.add(next)) pq.add(next);
            }
        }
        return (int) val;
    }
}

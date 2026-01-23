package proj.hobby.dsa.math;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/super-ugly-number/description/
 *
 */
public class SuperUglyNumber {

    /**
     * Technique: "K-Stream" Merge using a Min-Heap or "Prime-Stream" - Merging using Heap
     *
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1) return 1;

        int[] uns = new int[n]; // uns -> ugly numbers array
        uns[0] = 1;

        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(l -> l[0]));
        for(int p : primes) {
            heap.offer(new long[]{p, 0, p});// val, index, prime
            //idx = which index of uns[] this prime was multiplied with
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

            // advance cur for merging

            // 1. “Give me the next number in prime p’s stream by multiplying p with the next superugly number".
            // 2. “Each heap entry remembers which ugly number it multiplied with a prime; after popping it,
            // we multiply the same prime with the next ugly number to advance that stream.”
            cur[0] = (long) uns[idx + 1] * p;
            cur[1]++; // advance index
            heap.offer(cur);
        }
        return uns[n - 1];
    }


    /**
     * This causes TLE for n = 100K & primes ~ 100
     *
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumberTLE(int n, int[] primes) {
        if(n == 1) return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        Set<Long> seen = new HashSet<>();
        seen.add(1L);
        while (n != 1) {
            long next = pq.poll();
            for(int p : primes) {
                long candidate = p * next;
                if(seen.add(candidate)) {
                    pq.offer(candidate);
                }
            }
            n--;
        }
        return (int) (long) pq.poll();
    }
}

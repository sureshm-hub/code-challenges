package proj.hobby.dsa.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * There is a standard solution "Sieve of Eratosthenes"  with complexity of O(n log log n)
 *
 * https://leetcode.com/problems/count-primes/
 *
 * Compleixity O(NSqrt(N))
 *
 */
public class CountPrimes {

    public int countPrimes(int n) {

        List<Integer> primes = new ArrayList<>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 ));
        if(n < 20 ) {
            return (int) primes.stream().filter(x  -> x < n).count();
        }

        int i = 21;
        while(i < n) {
            boolean isPrime = true;
            for(int p : primes) {
                if((long) p * p  > i ) break; // < (int) Math.sqrt(i - 1)) break;

                if(i %  p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primes.add(i);
            i++;
        }
        return primes.size();
    }
}

package proj.hobby.dsa.math;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * https://leetcode.com/problems/random-pick-with-weight
 */
public class RandomPickWeight {

    private int[] prefixes;
    private Random rand = new Random();

    public RandomPickWeight(int[] w) {
        int N = w.length;
        prefixes = new int[N];
        prefixes[0] = w[0];
        for(int i = 1 ; i < N; i++) {
            prefixes[i] = w[i] + prefixes[i-1];
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(prefixes[prefixes.length - 1]) + 1;

        // find first index with prefixes[i] >= target
        int idx = Arrays.binarySearch(prefixes, target);
        if (idx < 0) {
            idx = -idx - 1;  // insertion point
        }
        return idx;
    }
}

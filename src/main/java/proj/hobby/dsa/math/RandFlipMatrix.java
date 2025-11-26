package proj.hobby.dsa.math;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/random-flip-matrix
 */
public class RandFlipMatrix {

    private final int rows;
    private final int cols;
    private final int total;
    private Set<Integer> used = new HashSet<>();
    private Random rand = new Random();

    public RandFlipMatrix(int m, int n) {
        rows = m;
        cols = n;
        total = m * n;
    }

    public int[] flip() {
        if(used.size() == total) return new int[] {};

        int index = rand.nextInt(total);
        while(used.contains(index)) {
            index = ++index % total;
        }
        used.add(index);
        return new int[]{index / cols, index % cols};
    }

    public void reset() {
        used.clear();
    }
}

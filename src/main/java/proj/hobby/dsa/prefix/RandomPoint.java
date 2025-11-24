package proj.hobby.dsa.prefix;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles
 *
 */
public class RandomPoint {

    private int[][] rects;
    private int[] areas;
    private Random rand;

    public RandomPoint(int[][] rects) {
        this.rand = new Random();
        this.rects = rects;
        areas = new int[rects.length];
        for(int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            areas[i] = getArea(r) + (i > 0 ? areas[i-1] : 0);
        }
    }

    public int[] pick() {
        int target = rand.nextInt(areas[areas.length - 1]);
        int index = findGreater(areas, target);
        int[] r = rects[index];
        return new int[] {
                rand.nextInt(r[2] - r[0] + 1) + r[0],
                rand.nextInt(r[3] - r[1] + 1) + r[1],
        };
    }

    private int getArea(int[] rect) {
        return Math.abs(rect[2] - rect[0] + 1) * Math.abs(rect[3] - rect[1] + 1);
    }

    private int findGreater(int[] areas, int target) {
        int idx = Arrays.binarySearch(areas, target + 1);
        return idx < 0 ? -idx - 1 : idx;
    }
}

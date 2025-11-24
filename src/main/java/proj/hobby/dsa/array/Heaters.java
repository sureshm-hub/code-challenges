package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/heaters/description
 *
 */
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);
        Arrays.sort(houses);

        int radius = 0;
        int idx = 0; // heaters index

        for(int h : houses) {
            while( idx + 1 < heaters.length  && h - heaters[idx] > heaters[idx + 1] - h)
                idx++;// next heater is better

            radius = Math.max(radius, Math.abs(h - heaters[idx]));
        }

        return radius;
    }
}

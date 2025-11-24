package proj.hobby.dsa.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/number-of-boomerangs
 */
public class CountBoomerangs {

    public int numberOfBoomerangs(int[][] points) {

        int ans = 0;
        for(int[] p : points) {
            Map<Long, Integer> dist = new HashMap<>();
            for(int[] q : points) {
                Long d = distance(p, q);
                dist.merge( d, 1, Integer::sum);
            }

            for(int freq : dist.values()) {
                ans += freq * (freq - 1); // C(freq, 2);
            }
        }

        return ans;
    }

    private long distance(int[] p1, int[] p2) {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        return x*x + y*y;
    }
}

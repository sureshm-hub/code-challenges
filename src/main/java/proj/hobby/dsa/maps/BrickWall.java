package proj.hobby.dsa.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/brick-wall
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {

        int N = wall.size();

        Map<Integer, Integer> crossings = new HashMap<>();

        for(List<Integer> row : wall) {
            int i = 0;
            for(int wi : row) {
                i += wi;
                crossings.merge(i, 1, (o, n) -> o + n);
            }
            crossings.remove(i);// end of wall
        }

        int min = N - crossings.values().stream().max(Integer::compare).orElse(0);
        return min;
    }

}

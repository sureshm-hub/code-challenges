package proj.hobby.dsa.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/water-and-jug-problem/
 */
public class WaterJug {

    public boolean canMeasureWater(int x, int y, int target) {

        if(x + y < target) return false;

        if(x == target || y == target || x + y == target) return true;

        int max = x + y;
        int[] states = {x, y, -x, -y};

        Deque<Integer> q = new ArrayDeque<Integer>();
        q.offer(0);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i : states) {
                int k = cur + i;
                if(k == target) return true;

                if(k >= 0 && k <= max && !visited.contains(k)) {
                    q.push(k);
                    visited.add(k);
                }
            }
        }

        return false;
    }
}

package proj.hobby.dsa.math;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/water-and-jug-problem/
 *
 * You can do DP here, but it’s the wrong mental model for this problem.  What your code is actually doing
 * It’s exploring all reachable total-water amounts (0 … x+y) using a graph search (BFS/DFS-ish):
 *
 * A state = “how many liters do I have in total across both jugs” (not the full (a,b) pair).
 * From any total cur, you try to move to cur + x, cur + y, cur - x, cur - y.
 * You keep totals in range [0, x+y] and avoid repeats with visited.
 *
 * So this is basically: Can we reach target from 0 using ±x and ±y, staying within [0, x+y]?
 *
 * DP here collapses into graph traversal anyway.  You don’t gain a clean bottom-up ordering (because moves can go up
 * and down). The real canonical solution (and why it beats both DP and BFS). The classic math fact is:
 *
 * You can measure target using jugs of size x and y iff
 * target <= x + y and gcd(x, y) divides target.
 *
 *
 */
public class WaterJug {

    public boolean canMeasureWater(int x, int y, int target) {

        if(x + y < target) return false;

        if(x == target || y == target || x + y == target) return true;

        int max = x + y;
        int[] states = {x, y, -x, -y};

        Deque<Integer> q = new ArrayDeque<>();
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

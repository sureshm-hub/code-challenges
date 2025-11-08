package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/elimination-game/description/
 *
 */
public class EliminationGame {

    public int lastRemaining(int n) {
        int lo = 1, step  = 1, rem = n;
        boolean forward = true;

        while(rem > 1) {
            if(forward || rem % 2 == 1) {
                lo += step;
            }
            rem /= 2;
            step *= 2;
            forward = !forward;
        }
        return lo;
    }
}

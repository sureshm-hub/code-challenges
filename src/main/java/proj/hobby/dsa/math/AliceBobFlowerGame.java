package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/alice-and-bob-playing-flower-game/description/
 */
public class AliceBobFlowerGame {

    public long flowerGame(int n, int m) {
        long pairs = 0;
        for(int i = 1; i <= n ; i++) {
            if( i%2 == 0) {
                pairs += m/2;
                if(m%2 == 1) pairs++;
            } else {
                pairs += m/2;
            }
        }
        return pairs;
    }

}

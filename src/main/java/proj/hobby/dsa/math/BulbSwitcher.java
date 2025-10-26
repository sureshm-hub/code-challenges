package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/bulb-switcher/description/
 */
public class BulbSwitcher {

    public int bulbSwitch(int n) {

        if(n == 0) return 0;

        int on = 0;
        int max = (int) Math.sqrt(n);
        for(int i = 1; i <= max; i++) {
            // boolean state = true;
            // for(int j = 2; j <= n; j++) {
            //     if(i % j == 0) {
            //         state = !state;
            //     }
            //     if(j > i )  break;
            // }
            on ++;
        }
        return on;
    }
}

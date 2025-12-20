package proj.hobby.dsa.bitwise;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/bulb-switcher-ii/description/
 *
 */
public class BubSwitcherII {

    public int flipLights(int n, int presses) {
        int[] buttonOps = new int[] {
                0b111111, // button 1: flip all
                0b010101,
                0b101010,
                0b100100,
        };

        Set<Integer> states = new HashSet<>();
        n = Math.min(n, 6); // only first 6 are considered for pattern repetition

        // try all possible comb's of button presses ( 2 ^ 4 = 16)
        for(int mask = 0; mask < (1 << 4); ++mask) {

            int pressCount = Integer.bitCount(mask);

            // pressing same button twice cancels out
            if( pressCount <= presses && pressCount % 2 == presses % 2) {

                int light = 0;
                for(int button = 0; button < 4; button++) {
                    if(((mask >> button) & 1) == 1) { //is button pressed
                        light ^= buttonOps[button]; // xor ot find light after button pressed
                    }
                }

                light &= ((1 << 6) - 1); //mask to keep only 6 bits

                light >>= (6 - n);//right shigt to keep only n bits and discard extras

                states.add(light);
            }
        }

        return states.size();
    }
}

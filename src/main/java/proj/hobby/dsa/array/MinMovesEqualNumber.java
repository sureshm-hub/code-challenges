package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description
 */
public class MinMovesEqualNumber {

    public int minMoves(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int min = Arrays.stream(nums).min().getAsInt();
        return sum - min * nums.length;
    }
}

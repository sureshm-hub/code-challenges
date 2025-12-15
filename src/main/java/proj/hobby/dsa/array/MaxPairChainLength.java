package proj.hobby.dsa.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/descriptio
 */
public class MaxPairChainLength {

    public int findLongestChain(int[][] pairs) {
        Comparator<int[]> pairComp = Comparator.comparingInt((int[] p) -> p[1]);
        Arrays.sort(pairs,  pairComp);

        int max = 0;
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < pairs.length; i++) {

            if(pairs[i][0] > prev) {
                max++;
                prev = pairs[i][1];
            }

        }
        return max;
    }
}

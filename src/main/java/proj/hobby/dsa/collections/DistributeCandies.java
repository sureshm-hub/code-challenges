package proj.hobby.dsa.collections;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/distribute-candies/description
 *
 */
public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        Set<Integer> candyTypes = new HashSet<>();
        for(int c : candyType) candyTypes.add(c);

        return Math.min(candyType.length / 2 , candyTypes.size());
    }
}

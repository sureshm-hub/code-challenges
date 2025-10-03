package proj.hobby.dsa.maps;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/single-number-ii
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {

        Set<Integer> all = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        for(int num : nums){
            if(all.contains(num)) {
                dups.add(num);
            }
            all.add(num);
        }
        all.removeAll(dups);
        return all.iterator().next();
    }
}

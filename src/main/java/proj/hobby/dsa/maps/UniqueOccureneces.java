package proj.hobby.dsa.maps;

import java.util.*;

/**
 *
 * Approach: java collections
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 *
 */
public class UniqueOccureneces {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for(int num: arr) {
            numCount.put(num, numCount.getOrDefault(num, 0)+1);
        }
        Set<Integer> uniqueCounts = new HashSet<>();
        uniqueCounts.addAll(numCount.values());
       return uniqueCounts.size() == numCount.size();
    }

    public static void main(String[] args) {
        UniqueOccureneces uo = new UniqueOccureneces();
        System.out.println("Unique Occureneces: "+uo.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println("Unique Occureneces: "+uo.uniqueOccurrences(new int[]{1,2}));
        System.out.println("Unique Occureneces: "+uo.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

}

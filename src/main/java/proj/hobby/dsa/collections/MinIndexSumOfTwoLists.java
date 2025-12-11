package proj.hobby.dsa.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 */
public class MinIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> indexMap1 = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            indexMap1.putIfAbsent(list1[i], i);
        }

        Map<Integer, List<String>> commonMap = new HashMap<>();
        int min =  list1.length + list2.length;// default max
        for(int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if(indexMap1.containsKey(s)) {
                int key = i  + indexMap1.get(s);// index from list1
                // List<String> vals = commonMap.getOrDefault(key, new ArrayList<>());
                // vals.add(s);
                // commonMap.put(key, vals);
                commonMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
                min = Math.min(min, key);
            }
        }

        return commonMap.get(min).toArray(new String[0]);
    }
}

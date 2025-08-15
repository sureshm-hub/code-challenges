package proj.hobby.dsa.maps;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 * Approach: Java Collections
 *
 * Complexity:
 *  TIme: O(NKLog(K)) - N Strings, K is string length
 *  Space: O(N)  - N Strings  - for HashMap
 */
public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> anags = new HashMap<>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            // using compute
            /**
             anags.compute(key, (k,v) -> {
             if(v == null) {
             v = new ArrayList<>();
             }
             v.add(s);
             return v;
             });
             */
            // using get/put
            // List<String> values = anags.getOrDefault(key, new ArrayList<>());
            // values.add(s);
            // anags.put(key, values);
            // using computeIfAbsent
            anags.computeIfAbsent(key, _ ->   new ArrayList<>()).add(s);
        }
        return new ArrayList<>(anags.values());
    }

}


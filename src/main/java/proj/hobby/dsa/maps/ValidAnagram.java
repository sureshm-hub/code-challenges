package proj.hobby.dsa.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> charMap = new HashMap<>();

        for(char c : s.toCharArray()) {
            charMap.merge(c, 1, Integer::sum);
        }

        for(char c : t.toCharArray()) {
            if(!charMap.containsKey(c)) return false;
            charMap.merge(c, -1, Integer::sum);
            charMap.remove(c, 0);
        }

        return charMap.isEmpty();
    }

}

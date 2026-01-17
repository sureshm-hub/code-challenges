package proj.hobby.dsa.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        char[] counts = new char[26];
        for(int i = 0; i < s.length(); i++) {
            int idx1 = s.charAt(i) - 'a';
            int idx2 = t.charAt(i) - 'a';
            counts[idx1]++;
            counts[idx2]--;
        }

        for(int i = 0; i < 26; i++) {
            if(counts[i] != 0) return false;
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {

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

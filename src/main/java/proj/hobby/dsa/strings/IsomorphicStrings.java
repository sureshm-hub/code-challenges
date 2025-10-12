package proj.hobby.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return s == null && t == null;
        return getIso(s).equals(getIso(t));
    }

    private String getIso(String s) {
        StringBuilder sIso = new StringBuilder();
        Map<Character, Integer> sMap = new HashMap<>();

        int charVal = 0;
        for(char c : s.toCharArray()) {
            int cur = 0;
            if (sMap.containsKey(c)) {
                cur = sMap.get(c);
            }  else {
                cur = charVal;
                sMap.put(c, charVal);
                charVal++;
            }
            sIso.append(cur).append("-");
        }
        return sIso.toString();
    }

}

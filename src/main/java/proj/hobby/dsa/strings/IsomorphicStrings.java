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
        if(s.length() != t.length()) return false;

        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // only checks for frequency not where the character appears
            // arr1[c1]++;
            // arr2[c2]++;
            // if(arr1[c1] != arr2[c2]) return false;

            /**
             *
             * 0 means not seen before. At position i, if the previous occurrence index of c1 in s is not the same as
             * the previous occurrence index of c2 in t, their repetition pattern differs, so the strings cannot be
             * isomorphic.
             *
             * effectively encodes the pattern “first time / second time / third time
             *
             */
            if(arr1[c1] != arr2[c2]) return false;

            arr1[c1] = i + 1;
            arr2[c2] = i + 1;
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
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

package proj.hobby.dsa.maps;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: java Collections
 *
 * Complexity:
 *  Time: O(N+M+kLogk) - N, M are word lengths and k unique chars
 *  Space: O(1)
 *
 */
public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {

        // Build Frequency Map for words
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i =0 ; i < word1.length(); i++) {
            char c = word1.charAt(i);
            map1.put(c , map1.getOrDefault(c, 0)+1);
        }
        for(int i =0 ; i < word2.length(); i++) {
            char c = word2.charAt(i);
            map2.put(c , map2.getOrDefault(c, 0)+1);
        }

        // if different number of chars in words then return false
        if(map1.size() == map2.size()) {
            if(map1.keySet().equals(map2.keySet())) { // check words have same distinct chars

                List<Integer> sortedFreq1 = new ArrayList<>(map1.values());
                Collections.sort(sortedFreq1);
                List<Integer> sortedFreq2 = new ArrayList<>(map2.values());
                Collections.sort(sortedFreq2);

                // check words have same  char fequencies
                return sortedFreq1.equals(sortedFreq2);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CloseStrings cs = new CloseStrings();
        System.out.println(cs.closeStrings("abc", "bca"));
        System.out.println(cs.closeStrings("a", "aa"));
        System.out.println(cs.closeStrings("cabbba", "abbccc"));
    }

}

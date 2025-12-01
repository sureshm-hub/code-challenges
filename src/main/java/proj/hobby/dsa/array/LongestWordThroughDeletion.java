package proj.hobby.dsa.array;

import java.util.Comparator;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description
 *
 */
public class LongestWordThroughDeletion {

    public String findLongestWord(String s, List<String> dictionary) {

        Comparator<String> byLen = (a, b) -> b.length() - a.length();
        Comparator<String> byLenByLexical = byLen.thenComparing(Comparator.naturalOrder());
        dictionary.sort(byLenByLexical);

        for(String word : dictionary) {
            int i = 0, j =0;
            while( i < word.length() && j < s.length()) {
                if(word.charAt(i) == s.charAt(j)) {
                    i++;
                }
                if(word.length() == i) return word;
                j++;
            }
        }
        return "";
    }
}

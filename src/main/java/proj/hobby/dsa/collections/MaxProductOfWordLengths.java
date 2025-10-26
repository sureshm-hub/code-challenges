package proj.hobby.dsa.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 */
public class MaxProductOfWordLengths {

    public int maxProduct(String[] words) {
        Map<Character, Set<Integer>> byChar = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            Set<Character> unq = new HashSet<>();
            for(char c : words[i].toCharArray()) {
                unq.add(c);
            }
            for(char c : unq) {
                byChar.computeIfAbsent(c, x -> new HashSet<>()).add(i);
            }
        }

        int max = 0;
        for(int i = 0; i < words.length; i++) {
            Set<Integer> excl = new HashSet<>();
            Set<Character> unq = new HashSet<>();
            for(char c : words[i].toCharArray()) {
                unq.add(c);
            }
            for(char c : unq) {
                excl.addAll(byChar.get(c));
            }
            for(int j = 0; j < words.length; j++) {
                if(!excl.contains(j)) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}

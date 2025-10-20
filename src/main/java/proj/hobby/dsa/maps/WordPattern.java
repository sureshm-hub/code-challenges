package proj.hobby.dsa.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/word-pattern/description/
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(words.length != pattern.length()) return false;

        Map<Character, String> patMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        int i = 0;
        for(char c : pattern.toCharArray()) {
            String word = words[i];
            if(patMap.containsKey(c)) {
                if(!patMap.get(c).equals(words[i++]) ) {
                    return false;
                } else {
                    continue;
                }
            } else {
                patMap.put(c, words[i++]);
            }

            if(wordMap.containsKey(word)) {
                if(! wordMap.get(word).equals(c)) {
                    return false;
                } else {
                    continue;
                }
            } else {
                wordMap.put(word, c);
            }
        }

        return true;
    }
}
